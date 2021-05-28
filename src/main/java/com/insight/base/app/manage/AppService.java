package com.insight.base.app.manage;

import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.pojo.Application;
import com.insight.utils.pojo.LoginInfo;
import com.insight.utils.pojo.Reply;
import com.insight.utils.pojo.SearchDto;

/**
 * @author 宣炳刚
 * @date 2019/12/11
 * @remark
 */
public interface AppService {

    /**
     * 查询应用列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    Reply getApps(SearchDto search);

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    Reply getApp(Long id);

    /**
     * 新增应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    Reply newApp(LoginInfo info, Application dto);

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    Reply editApp(LoginInfo info, Application dto);

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @return Reply
     */
    Reply deleteApp(LoginInfo info, Long id);

    /**
     * 获取导航列表
     *
     * @param appId 应用ID
     * @return Reply
     */
    Reply getNavigators(Long appId);

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    Reply getNavigator(Long id);

    /**
     * 新增导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    Reply newNavigator(LoginInfo info, Navigator dto);

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    Reply editNavigator(LoginInfo info, Navigator dto);

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @return Reply
     */
    Reply deleteNavigator(LoginInfo info, Long id);

    /**
     * 获取功能列表
     *
     * @param navId 导航ID
     * @return Reply
     */
    Reply getFunctions(Long navId);

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    Reply getFunction(Long id);

    /**
     * 新增功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    Reply newFunction(LoginInfo info, Function dto);

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    Reply editFunction(LoginInfo info, Function dto);

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @return Reply
     */
    Reply deleteFunction(LoginInfo info, Long id);

    /**
     * 获取日志列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    Reply getAppLogs(SearchDto search);

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    Reply getAppLog(Long id);
}
