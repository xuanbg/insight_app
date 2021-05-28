package com.insight.base.app.manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insight.base.app.common.client.LogClient;
import com.insight.base.app.common.client.LogServiceClient;
import com.insight.base.app.common.dto.AppListDto;
import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.base.app.common.mapper.AppMapper;
import com.insight.utils.ReplyHelper;
import com.insight.utils.SnowflakeCreator;
import com.insight.utils.pojo.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 宣炳刚
 * @date 2019/12/11
 * @remark
 */
@Service
public class AppServiceImpl implements AppService {
    private static final String BUSINESS = "资源管理";
    private final SnowflakeCreator creator;
    private final AppMapper mapper;
    private final LogServiceClient client;

    /**
     * 构造方法
     *
     * @param creator 雪花算法ID生成器
     * @param mapper  AppMapper
     * @param client  LogServiceClient
     */
    public AppServiceImpl(SnowflakeCreator creator, AppMapper mapper, LogServiceClient client) {
        this.creator = creator;
        this.mapper = mapper;
        this.client = client;
    }

    /**
     * 查询应用列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @Override
    public Reply getApps(SearchDto search) {
        PageHelper.startPage(search.getPage(), search.getSize());
        List<AppListDto> apps = mapper.getApps(search.getKeyword());
        PageInfo<AppListDto> pageInfo = new PageInfo<>(apps);

        return ReplyHelper.success(apps, pageInfo.getTotal());
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @Override
    public Reply getApp(Long id) {
        Application app = mapper.getApp(id);
        if (app == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        return ReplyHelper.success(app);
    }

    /**
     * 新增应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @Override
    public Reply newApp(LoginInfo info, Application dto) {
        Long id = creator.nextId(0);
        dto.setId(id);

        Long permitLife = dto.getPermitLife();
        if (permitLife == null || permitLife == 0) {
            dto.setPermitLife(300000L);
        }

        Long tokenLife = dto.getTokenLife();
        if (tokenLife == null || tokenLife == 0) {
            dto.setTokenLife(7200000L);
        }

        if (dto.getSigninOne() == null) {
            dto.setSigninOne(false);
        }

        if (dto.getAutoRefresh() == null) {
            dto.setAutoRefresh(false);
        }

        dto.setCreator(info.getUserName());
        dto.setCreatorId(info.getUserId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addApp(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.INSERT, id, dto);

        return ReplyHelper.created(id);
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @Override
    public Reply editApp(LoginInfo info, Application dto) {
        Long id = dto.getId();
        Application app = mapper.getApp(id);
        if (app == null) {
            return ReplyHelper.fail("ID不存在,未更新数据");
        }

        mapper.updateApp(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.UPDATE, id, dto);

        return ReplyHelper.success();
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @return Reply
     */
    @Override
    public Reply deleteApp(LoginInfo info, Long id) {
        Application app = mapper.getApp(id);
        if (app == null) {
            return ReplyHelper.fail("ID不存在,未删除数据");
        }

        mapper.deleteApp(id);
        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, app);

        return ReplyHelper.success();
    }

    /**
     * 获取导航列表
     *
     * @param appId 应用ID
     * @return Reply
     */
    @Override
    public Reply getNavigators(Long appId) {
        Application app = mapper.getApp(appId);
        if (app == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        List<NavListDto> navigators = mapper.getNavigators(appId);

        return ReplyHelper.success(navigators);
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @Override
    public Reply getNavigator(Long id) {
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        return ReplyHelper.success(navigator);
    }

    /**
     * 新增导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    @Override
    public Reply newNavigator(LoginInfo info, Navigator dto) {
        Long id = creator.nextId(1);
        dto.setId(id);
        dto.setCreator(info.getUserName());
        dto.setCreatorId(info.getUserId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addNavigator(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.INSERT, id, dto);

        return ReplyHelper.created(id);
    }

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    @Override
    public Reply editNavigator(LoginInfo info, Navigator dto) {
        Long id = dto.getId();
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            return ReplyHelper.fail("ID不存在,未更新数据");
        }

        mapper.updateNavigator(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.UPDATE, id, dto);

        return ReplyHelper.success();
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @return Reply
     */
    @Override
    public Reply deleteNavigator(LoginInfo info, Long id) {
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            return ReplyHelper.fail("ID不存在,未删除数据");
        }

        if (navigator.getType() == 1) {
            mapper.deleteNavigator(id);
        } else {
            mapper.deleteModule(id);
        }

        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, navigator);

        return ReplyHelper.success();
    }

    /**
     * 获取功能列表
     *
     * @param navId 导航ID
     * @return Reply
     */
    @Override
    public Reply getFunctions(Long navId) {
        Navigator navigator = mapper.getNavigator(navId);
        if (navigator == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        List<FuncListDto> functions = mapper.getFunctions(navId);

        return ReplyHelper.success(functions);
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @Override
    public Reply getFunction(Long id) {
        Function function = mapper.getFunction(id);
        if (function == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        return ReplyHelper.success(function);
    }

    /**
     * 新增功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    @Override
    public Reply newFunction(LoginInfo info, Function dto) {
        Long id = creator.nextId(1);
        dto.setId(id);
        dto.setCreator(info.getUserName());
        dto.setCreatorId(info.getUserId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addFunction(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.INSERT, id, dto);

        return ReplyHelper.created(id);
    }

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    @Override
    public Reply editFunction(LoginInfo info, Function dto) {
        Long id = dto.getId();
        Function function = mapper.getFunction(id);
        if (function == null) {
            return ReplyHelper.fail("ID不存在,未更新数据");
        }

        mapper.updateFunction(dto);
        LogClient.writeLog(info, BUSINESS, OperateType.UPDATE, id, dto);

        return ReplyHelper.success();
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @return Reply
     */
    @Override
    public Reply deleteFunction(LoginInfo info, Long id) {
        Function function = mapper.getFunction(id);
        if (function == null) {
            return ReplyHelper.fail("ID不存在,未删除数据");
        }

        mapper.deleteFunction(id);
        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, function);

        return ReplyHelper.success();
    }

    /**
     * 获取日志列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @Override
    public Reply getAppLogs(SearchDto search) {
        return client.getLogs(BUSINESS, search.getKeyword(), search.getPage(), search.getSize());
    }

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @Override
    public Reply getAppLog(Long id) {
        return client.getLog(id);
    }
}
