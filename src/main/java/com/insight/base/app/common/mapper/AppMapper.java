package com.insight.base.app.common.mapper;

import com.insight.base.app.common.dto.AppListDto;
import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Application;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.pojo.app.FuncInfo;
import com.insight.utils.pojo.app.ModuleInfo;
import com.insight.utils.pojo.base.JsonTypeHandler;
import com.insight.utils.pojo.base.Search;
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
     * @param search 查询实体类
     * @return 应用列表
     */
    @Select("<script>select id, `index`, name, alias, domain, permit_life, token_life, verify_source, signin_one, auto_refresh from ibs_application " +
            "<if test = 'keyword!=null'>where `name` like concat('%',#{keyword},'%') or alias = #{keyword} or domain like concat('%',#{keyword},'%') </if>" +
            "</script>")
    List<AppListDto> getApps(Search search);

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return 应用详情
     */
    @Select("select * from ibs_application where id = #{id};")
    Application getApp(Long id);

    /**
     * 新增应用
     *
     * @param app 应用DTO
     */
    @Insert("insert ibs_application (id, `index`, `name`, alias, icon, domain, permit_life, token_life, " +
            "verify_source, signin_one, auto_refresh, creator, creator_id, created_time) " +
            "values (#{id}, #{index}, #{name}, #{alias}, #{icon}, #{domain}, #{permitLife}, #{tokenLife}, " +
            "#{verifySource}, #{signinOne}, #{autoRefresh}, #{creator}, #{creatorId}, #{createdTime});")
    void addApp(Application app);

    /**
     * 更新应用
     *
     * @param app 应用DTO
     */
    @Update("update ibs_application set `index` = #{index}, `name` = #{name}, alias = #{alias}, icon = #{icon}, domain = #{domain}, " +
            "permit_life = #{permitLife}, token_life = #{tokenLife}, verify_source = #{verifySource}, " +
            "signin_one = #{signinOne}, auto_refresh = #{autoRefresh} where id = #{id};")
    void updateApp(Application app);

    /**
     * 删除应用
     *
     * @param id 应用ID
     */
    @Delete("delete a, n, f, p from ibs_application a left join ibs_navigator n on n.app_id = a.id left join ibs_function f on f.nav_id = n.id " +
            "left join ibr_role_permit p on p.function_id = f.id where a.id = #{id};")
    void deleteApp(Long id);

    /**
     * 获取导航列表
     *
     * @param appId 应用ID
     * @return 导航列表
     */
    @Results({@Result(property = "moduleInfo", column = "module_info", javaType = ModuleInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select id, parent_id, app_id, type, `index`, `name`, module_info from ibs_navigator where app_id = #{appId} order by type, `index`;")
    List<NavListDto> getNavigators(Long appId);

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return 导航详情
     */
    @Results({@Result(property = "moduleInfo", column = "module_info", javaType = ModuleInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select * from ibs_navigator where id = #{id};")
    Navigator getNavigator(Long id);

    /**
     * 新增导航
     *
     * @param navigator 导航DTO
     */
    @Insert("insert ibs_navigator(id, parent_id, app_id, type, `index`, `name`, module_info, creator, creator_id, created_time) values " +
            "(#{id}, #{parentId}, #{appId}, #{type}, #{index}, #{name}, #{moduleInfo, typeHandler = com.insight.utils.pojo.base.JsonTypeHandler}, " +
            "#{creator}, #{creatorId}, #{createdTime});")
    void addNavigator(Navigator navigator);

    /**
     * 更新导航
     *
     * @param navigator 导航DTO
     */
    @Update("update ibs_navigator set parent_id = #{parentId}, app_id = #{appId}, type = #{type}, `index` = #{index}, `name` = #{name}, " +
            "module_info = #{moduleInfo, typeHandler = com.insight.utils.pojo.base.JsonTypeHandler} where id = #{id};")
    void updateNavigator(Navigator navigator);

    /**
     * 删除一级导航
     *
     * @param id 导航ID
     */
    @Delete("delete n, m, f, p from ibs_navigator n left join ibs_navigator m on m.parent_id = n.id left join ibs_function f on f.nav_id = m.id " +
            "left join ibr_role_permit p on p.function_id = f.id where n.id = #{id};")
    void deleteNavigator(Long id);

    /**
     * 删除二级导航
     *
     * @param id 导航ID
     */
    @Delete("delete m, f, p from ibs_navigator m left join ibs_function f on f.nav_id = m.id " +
            "left join ibr_role_permit p on p.function_id = f.id where m.id = #{id};")
    void deleteModule(Long id);

    /**
     * 获取功能列表
     *
     * @param navId 应用ID
     * @return 导航列表
     */
    @Results({@Result(property = "funcInfo", column = "func_info", javaType = FuncInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select id, nav_id, type, `index`, `name`, auth_codes, func_info from ibs_function where nav_id = #{navId} order by `index`;")
    List<FuncListDto> getFunctions(Long navId);

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return 功能详情
     */
    @Results({@Result(property = "funcInfo", column = "func_info", javaType = FuncInfo.class, typeHandler = JsonTypeHandler.class)})
    @Select("select * from ibs_function where id = #{id};")
    Function getFunction(Long id);

    /**
     * 新增功能
     *
     * @param function 功能DTO
     */
    @Insert("insert ibs_function(id, nav_id, type, `index`, `name`, auth_codes, func_info, creator, creator_id, created_time) values " +
            "(#{id}, #{navId}, #{type}, #{index}, #{name}, #{authCodes}, #{funcInfo, typeHandler = com.insight.utils.pojo.base.JsonTypeHandler}, " +
            "#{creator}, #{creatorId}, #{createdTime});")
    void addFunction(Function function);

    /**
     * 更新功能
     *
     * @param function 功能DTO
     */
    @Update("update ibs_function set nav_id = #{navId}, type = #{type}, `index` = #{index}, `name` = #{name}, auth_codes = #{authCodes}, " +
            "func_info = #{funcInfo, typeHandler = com.insight.utils.pojo.base.JsonTypeHandler} where id = #{id};")
    void updateFunction(Function function);

    /**
     * 删除功能
     *
     * @param id 功能ID
     */
    @Delete("delete f, p from ibs_function f left join ibr_role_permit p on p.function_id = f.id where f.id = #{id};")
    void deleteFunction(Long id);
}
