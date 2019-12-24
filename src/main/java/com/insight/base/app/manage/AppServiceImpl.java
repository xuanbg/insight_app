package com.insight.base.app.manage;

import com.insight.base.app.common.dto.AppListDto;
import com.insight.base.app.common.entity.App;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.base.app.common.mapper.AppMapper;
import com.insight.util.ReplyHelper;
import com.insight.util.pojo.LoginInfo;
import com.insight.util.pojo.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 宣炳刚
 * @date 2019/12/11
 * @remark
 */
@Service
public class AppServiceImpl implements AppService {
    private final AppMapper mapper;

    /**
     * 构造方法
     *
     * @param mapper AppMapper
     */
    public AppServiceImpl(AppMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询应用列表
     *
     * @param keyword 查询关键词
     * @return Reply
     */
    @Override
    public Reply getApps(String keyword) {
        List<AppListDto> list = mapper.getApps(keyword);

        return ReplyHelper.success(list);
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @Override
    public Reply getApp(String id) {
        App app = mapper.getApp(id);
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
    public Reply newApp(LoginInfo info, App dto) {
        return null;
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @Override
    public Reply editApp(LoginInfo info, App dto) {
        return null;
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @return Reply
     */
    @Override
    public Reply deleteApp(LoginInfo info, String id) {
        return null;
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @Override
    public Reply getNavigator(String id) {
        Navigator navigator = mapper.getNavigator(id);
        if (navigator == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        return null;
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
        return null;
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
        return null;
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @return Reply
     */
    @Override
    public Reply deleteNavigator(LoginInfo info, String id) {
        return null;
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @Override
    public Reply getFunction(String id) {
        Function function = mapper.getFunction(id);
        if (function == null) {
            return ReplyHelper.fail("ID不存在,未读取数据");
        }

        return null;
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
        return null;
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
        return null;
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @return Reply
     */
    @Override
    public Reply deleteFunction(LoginInfo info, String id) {
        return null;
    }

    /**
     * 获取日志列表
     *
     * @param keyword 查询关键词
     * @param page    分页页码
     * @param size    每页记录数
     * @return Reply
     */
    @Override
    public Reply getAppLogs(String keyword, int page, int size) {
        return null;
    }

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @Override
    public Reply getAppLog(String id) {
        return null;
    }
}
