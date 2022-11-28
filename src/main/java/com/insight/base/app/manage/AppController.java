package com.insight.base.app.manage;

import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.Json;
import com.insight.utils.pojo.app.Application;
import com.insight.utils.pojo.auth.LoginInfo;
import com.insight.utils.pojo.base.Reply;
import com.insight.utils.pojo.base.Search;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 宣炳刚
 * @date 2019/12/11
 * @remark 应用管理服务控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/base/resource")
public class AppController {
    private final AppService service;

    /**
     * 构造方法
     *
     * @param service 自动注入的Service
     */
    public AppController(AppService service) {
        this.service = service;
    }

    /**
     * 查询应用列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @GetMapping("/v1.0/apps")
    public Reply getApps(Search search) {
        return service.getApps(search);
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/{id}")
    public Application getApp(@PathVariable Long id) {
        return service.getApp(id);
    }

    /**
     * 新增应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @PostMapping("/v1.0/apps")
    public Long newApp(@RequestHeader("loginInfo") String info, @Valid @RequestBody Application dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newApp(loginInfo, dto);
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @param dto  应用DTO
     */
    @PutMapping("/v1.0/apps/{id}")
    public void editApp(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Application dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        service.editApp(loginInfo, dto);
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     */
    @DeleteMapping("/v1.0/apps/{id}")
    public void deleteApp(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        service.deleteApp(loginInfo, id);
    }

    /**
     * 获取导航详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/{id}/navigators")
    public List<NavListDto> getNavigators(@PathVariable Long id) {
        return service.getNavigators(id);
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @GetMapping("/v1.0/navigators/{id}")
    public Navigator getNavigator(@PathVariable Long id) {
        return service.getNavigator(id);
    }

    /**
     * 新增导航
     *
     * @param info 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    @PostMapping("/v1.0/navigators")
    public Long newNavigator(@RequestHeader("loginInfo") String info, @Valid @RequestBody Navigator dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newNavigator(loginInfo, dto);
    }

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @param dto  导航DTO
     */
    @PutMapping("/v1.0/navigators/{id}")
    public void editNavigator(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Navigator dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        service.editNavigator(loginInfo, dto);
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     */
    @DeleteMapping("/v1.0/navigators/{id}")
    public void deleteNavigator(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        service.deleteNavigator(loginInfo, id);
    }

    /**
     * 获取功能列表
     *
     * @param id 导航ID
     * @return Reply
     */
    @GetMapping("/v1.0/navigators/{id}/functions")
    public List<FuncListDto> getFunctions(@PathVariable Long id) {
        return service.getFunctions(id);
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @GetMapping("/v1.0/functions/{id}")
    public Function getFunction(@PathVariable Long id) {
        return service.getFunction(id);
    }

    /**
     * 新增功能
     *
     * @param info 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    @PostMapping("/v1.0/functions")
    public Long newFunction(@RequestHeader("loginInfo") String info, @Valid @RequestBody Function dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newFunction(loginInfo, dto);
    }

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @param dto  功能DTO
     */
    @PutMapping("/v1.0/functions/{id}")
    public void editFunction(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Function dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        service.editFunction(loginInfo, dto);
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     */
    @DeleteMapping("/v1.0/functions/{id}")
    public void deleteFunction(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        service.deleteFunction(loginInfo, id);
    }

    /**
     * 获取日志列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @GetMapping("/v1.0/apps/logs")
    public Reply getAppLogs(Search search) {
        return service.getAppLogs(search);
    }

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/logs/{id}")
    public Reply getAppLog(@PathVariable Long id) {
        return service.getAppLog(id);
    }
}
