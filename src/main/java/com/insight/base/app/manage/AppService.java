package com.insight.base.app.manage;

import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.pojo.app.Application;
import com.insight.utils.pojo.auth.LoginInfo;
import com.insight.utils.pojo.base.Reply;
import com.insight.utils.pojo.base.Search;

import java.util.List;

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
    Reply getApps(Search search);

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    Application getApp(Long id);

    /**
     * 新增应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    Long newApp(LoginInfo info, Application dto);

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     */
    void editApp(LoginInfo info, Application dto);

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     */
    void deleteApp(LoginInfo info, Long id);

    /**
     * 获取导航列表
     *
     * @param appId 应用ID
     * @return Reply
     */
    List<NavListDto> getNavigators(Long appId);

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    Navigator getNavigator(Long id);

    /**
     * 新增导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    Long newNavigator(LoginInfo info, Navigator dto);

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     */
    void editNavigator(LoginInfo info, Navigator dto);

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     */
    void deleteNavigator(LoginInfo info, Long id);

    /**
     * 获取功能列表
     *
     * @param navId 导航ID
     * @return Reply
     */
    List<FuncListDto> getFunctions(Long navId);

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    Function getFunction(Long id);

    /**
     * 新增功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    Long newFunction(LoginInfo info, Function dto);

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     */
    void editFunction(LoginInfo info, Function dto);

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     */
    void deleteFunction(LoginInfo info, Long id);
}
