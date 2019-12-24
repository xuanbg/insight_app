package com.insight.base.app.common.mapper;

import com.insight.base.app.common.dto.*;
import com.insight.base.app.common.entity.App;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 宣炳刚
 * @date 2019/12/4
 * @remark 应用DTO
 */
@Mapper
public interface AppMapper {

    /**
     * 获取应用列表
     *
     * @param key      查询关键词
     * @return 应用列表
     */
    @Select("<script>select * from (select a.id, null as parent_id, 0 as type, a.index, a.name, a.icon from ibs_application a " +
            "<if test = 'key!=null'>where a.name like concat('%',#{key},'%') </if>" +
            "union all select n.id, case when n.parent_id is null then n.app_id else n.parent_id end as parent_id, n.type, n.index, n.name, n.module_info ->> '$.icon' as icon " +
            "from ibs_application a join ibs_navigator n on n.app_id = a.id " +
            "<if test = 'key!=null'>where a.name like concat('%',#{key},'%') </if>" +
            "union all select f.id, f.nav_id as parent_id, 3 as type, f.index, f.name, f.icon_info ->> '$.icon' as icon " +
            "from ibs_application a join ibs_navigator n on n.app_id = a.id join ibs_function f on f.nav_id = n.id " +
            "<if test = 'key!=null'>where a.name like concat('%',#{key},'%') </if>" +
            ") t order by t.index;</script>")
    List<AppListDto> getApps(@Param("key") String key);

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Select("select * from ibs_application where id = #{id};")
    App getApp(String id);

    /**
     * 新增应用
     *
     * @param app 应用DTO
     */
    @Insert("insert ibs_application(id, index, name, alias, icon, domain, permit_life, token_life, is_signin_one, is_auto_refresh, is_auto_tenant, creator, creator_id, created_time) values " +
            "(#{id}, #{index}, #{name}, #{alias}, #{icon}, #{domain}, #{permitLife}, #{tokenLife}, #{isSigninOne}, #{isAutoRefresh}, #{isAutoTenant}, #{creator}, #{creatorId}, #{createdTime});")
    void addApp(App app);

    /**
     * 更新应用
     *
     * @param app 应用DTO
     */
    @Update("update ibs_application set index = #{index}, name = #{name}, alias = #{alias}, icon = #{icon}, domain = #{domain}, permit_life = #{permitLife}, " +
            "token_life = #{tokenLife}, is_signin_one = #{isSigninOne}, is_auto_refresh = #{isAutoRefresh}, is_auto_tenant = #{isAutoTenant} where id = #{id};")
    void updateApp(App app);

    /**
     * 删除应用
     *
     * @param id 应用ID
     */
    @Delete("delete a, n, f from ibs_application a left join ibs_navigator n on n.app_id = a.id left join ibs_function f on f.nav_id = n.id where a.id = #{id};")
    void deleteApp(String id);

    /**
     * 获取导航详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Select("select * from ibs_navigator where id = #{id};")
    Navigator getNavigator(String id);

    /**
     * 获取功能详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Select("select * from ibs_function where id = #{id};")
    Function getFunction(String id);

}
