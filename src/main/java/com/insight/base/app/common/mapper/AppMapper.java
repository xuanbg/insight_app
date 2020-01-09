package com.insight.base.app.common.mapper;

import com.insight.base.app.common.dto.AppListDto;
import com.insight.base.app.common.entity.App;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.util.common.JsonTypeHandler;
import com.insight.util.pojo.FuncInfo;
import com.insight.util.pojo.ModuleInfo;
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
    @Select("<script>select id, name, alias, domain, permit_life, token_life, is_signin_one, is_auto_refresh, is_auto_tenant from ibs_application " +
            "<if test = 'key!=null'>where `name` like concat('%',#{key},'%') </if>" +
            "order by `index`;</script>")
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
    @Insert("insert ibs_application (id, `index`, `name`, alias, icon, domain, permit_life, token_life, is_signin_one, is_auto_refresh, is_auto_tenant, creator, creator_id, created_time) values " +
            "(#{id}, #{index}, #{name}, #{alias}, #{icon}, #{domain}, #{permitLife}, #{tokenLife}, #{isSigninOne}, #{isAutoRefresh}, #{isAutoTenant}, #{creator}, #{creatorId}, #{createdTime});")
    void addApp(App app);

    /**
     * 更新应用
     *
     * @param app 应用DTO
     */
    @Update("update ibs_application set `index` = #{index}, `name` = #{name}, alias = #{alias}, icon = #{icon}, domain = #{domain}, permit_life = #{permitLife}, " +
            "token_life = #{tokenLife}, is_signin_one = #{isSigninOne}, is_auto_refresh = #{isAutoRefresh}, is_auto_tenant = #{isAutoTenant} where id = #{id};")
    void updateApp(App app);

    /**
     * 删除应用
     *
     * @param id 应用ID
     */
    @Delete("delete a, n, f, p from ibs_application a left join ibs_navigator n on n.app_id = a.id left join ibs_function f on f.nav_id = n.id " +
            "left join ibr_role_func_permit p on p.function_id = f.id where a.id = #{id};")
    void deleteApp(String id);

    /**
     * 获取导航详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Results({@Result(property = "moduleInfo", column = "module_info", javaType = ModuleInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select * from ibs_navigator where id = #{id};")
    Navigator getNavigator(String id);

    /**
     * 新增导航
     *
     * @param navigator 导航DTO
     */
    @Insert("insert ibs_navigator(id, parent_id, app_id, type, `index`, `name`, module_info, remark, creator, creator_id, created_time) values " +
            "(#{id}, #{parentId}, #{appId}, #{type}, #{index}, #{name}, #{moduleInfo, typeHandler = com.insight.util.common.JsonTypeHandler}, " +
            "#{remark}, #{creator}, #{creatorId}, #{createdTime});")
    void addNavigator(Navigator navigator);

    /**
     * 更新导航
     *
     * @param navigator 导航DTO
     */
    @Update("update ibs_navigator set parent_id = #{parentId}, app_id = #{appId}, type = #{type}, `index` = #{index}, `name` = #{name}, " +
            "module_info = #{moduleInfo, typeHandler = com.insight.util.common.JsonTypeHandler}, remark = #{remark} where id = #{id};")
    void updateNavigator(Navigator navigator);

    /**
     * 删除导航
     *
     * @param id 导航ID
     */
    @Delete("delete n, m, f, p from ibs_navigator n left join ibs_navigator m on m.parent_id = n.id left join ibs_function f on f.nav_id = m.id " +
            "left join ibr_role_func_permit p on p.function_id = f.id where n.id = #{id};")
    void deleteNavigator(String id);

    /**
     * 删除导航
     *
     * @param id 导航ID
     */
    @Delete("delete m, f, p from ibs_navigator m left join ibs_function f on f.nav_id = m.id " +
            "left join ibr_role_func_permit p on p.function_id = f.id where m.id = #{id};")
    void deleteModule(String id);

    /**
     * 获取功能详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Results({@Result(property = "funcInfo", column = "func_info", javaType = FuncInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select * from ibs_function where id = #{id};")
    Function getFunction(String id);

    /**
     * 新增功能
     *
     * @param function 功能DTO
     */
    @Insert("insert ibs_function(id, nav_id, type, `index`, `name`, auth_codes, func_info, remark, creator, creator_id, created_time) values " +
            "(#{id}, #{navId}, #{type}, #{index}, #{name}, #{authCodes}, #{iconInfo, typeHandler = com.insight.util.common.JsonTypeHandler}, " +
            "#{remark}, #{creator}, #{creatorId}, #{createdTime});")
    void addFunction(Function function);

    /**
     * 更新功能
     *
     * @param function 功能DTO
     */
    @Update("update ibs_function set nav_id = #{navId}, type = #{type}, `index` = #{index}, `name` = #{name}, auth_codes = #{authCodes}, " +
            "func_info = #{iconInfo, typeHandler = com.insight.util.common.JsonTypeHandler}, remark = #{remark} where id = #{id};")
    void updateFunction(Function function);

    /**
     * 删除功能
     *
     * @param id 功能ID
     */
    @Delete("delete f, p from ibs_function f left join ibr_role_func_permit p on p.function_id = f.id where f.id = #{id};")
    void deleteFunction(String id);
}
