package com.insight.base.app.manage;

import com.github.pagehelper.PageHelper;
import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.base.app.common.mapper.AppMapper;
import com.insight.utils.ReplyHelper;
import com.insight.utils.SnowflakeCreator;
import com.insight.utils.pojo.app.Application;
import com.insight.utils.pojo.auth.LoginInfo;
import com.insight.utils.pojo.base.BusinessException;
import com.insight.utils.pojo.base.Reply;
import com.insight.utils.pojo.base.Search;
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
    private final SnowflakeCreator creator;
    private final AppMapper mapper;

    /**
     * 构造方法
     *
     * @param creator 雪花算法ID生成器
     * @param mapper  AppMapper
     */
    public AppServiceImpl(SnowflakeCreator creator, AppMapper mapper) {
        this.creator = creator;
        this.mapper = mapper;
    }

    /**
     * 查询应用列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @Override
    public Reply getApps(Search search) {
        try (var page = PageHelper.startPage(search.getPageNum(), search.getPageSize())
                .setOrderBy(search.getOrderBy()).doSelectPage(() -> mapper.getApps(search))) {
            var total = page.getTotal();
            return total > 0 ? ReplyHelper.success(page.getResult(), total) : ReplyHelper.resultIsEmpty();
        }
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @Override
    public Application getApp(Long id) {
        Application app = mapper.getApp(id);
        if (app == null) {
            throw new BusinessException("ID不存在,未读取数据");
        }

        return app;
    }

    /**
     * 新增应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @Override
    public Long newApp(LoginInfo info, Application dto) {
        Long id = creator.nextId(0);
        dto.setId(id);
        dto.setCreator(info.getName());
        dto.setCreatorId(info.getId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addApp(dto);
        return id;
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     */
    @Override
    public void editApp(LoginInfo info, Application dto) {
        Long id = dto.getId();
        Application app = mapper.getApp(id);
        if (app == null) {
            throw new BusinessException("ID不存在,未更新数据");
        }

        mapper.updateApp(dto);
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     */
    @Override
    public void deleteApp(LoginInfo info, Long id) {
        Application app = mapper.getApp(id);
        if (app == null) {
            throw new BusinessException("ID不存在,未删除数据");
        }

        mapper.deleteApp(id);
    }

    /**
     * 获取导航列表
     *
     * @param appId 应用ID
     * @return Reply
     */
    @Override
    public List<NavListDto> getNavigators(Long appId) {
        Application app = mapper.getApp(appId);
        if (app == null) {
            throw new BusinessException("ID不存在,未读取数据");
        }

        return mapper.getNavigators(appId);
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @Override
    public Navigator getNavigator(Long id) {
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            throw new BusinessException("ID不存在,未读取数据");
        }

        return navigator;
    }

    /**
     * 新增导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    @Override
    public Long newNavigator(LoginInfo info, Navigator dto) {
        Long id = creator.nextId(1);
        dto.setId(id);
        dto.setCreator(info.getName());
        dto.setCreatorId(info.getId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addNavigator(dto);
        return id;
    }

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     */
    @Override
    public void editNavigator(LoginInfo info, Navigator dto) {
        Long id = dto.getId();
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            throw new BusinessException("ID不存在,未更新数据");
        }

        mapper.updateNavigator(dto);
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     */
    @Override
    public void deleteNavigator(LoginInfo info, Long id) {
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            throw new BusinessException("ID不存在,未删除数据");
        }

        if (navigator.getType() == 1) {
            mapper.deleteNavigator(id);
        } else {
            mapper.deleteModule(id);
        }
    }

    /**
     * 获取功能列表
     *
     * @param navId 导航ID
     * @return Reply
     */
    @Override
    public List<FuncListDto> getFunctions(Long navId) {
        Navigator navigator = mapper.getNavigator(navId);
        if (navigator == null) {
            throw new BusinessException("ID不存在,未读取数据");
        }

        return mapper.getFunctions(navId);
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @Override
    public Function getFunction(Long id) {
        Function function = mapper.getFunction(id);
        if (function == null) {
            throw new BusinessException("ID不存在,未读取数据");
        }

        return function;
    }

    /**
     * 新增功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    @Override
    public Long newFunction(LoginInfo info, Function dto) {
        Long id = creator.nextId(1);
        dto.setId(id);
        dto.setCreator(info.getName());
        dto.setCreatorId(info.getId());
        dto.setCreatedTime(LocalDateTime.now());

        mapper.addFunction(dto);
        return id;
    }

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     */
    @Override
    public void editFunction(LoginInfo info, Function dto) {
        Long id = dto.getId();
        Function function = mapper.getFunction(id);
        if (function == null) {
            throw new BusinessException("ID不存在,未更新数据");
        }

        mapper.updateFunction(dto);
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     */
    @Override
    public void deleteFunction(LoginInfo info, Long id) {
        Function function = mapper.getFunction(id);
        if (function == null) {
            throw new BusinessException("ID不存在,未删除数据");
        }

        mapper.deleteFunction(id);
    }
}
