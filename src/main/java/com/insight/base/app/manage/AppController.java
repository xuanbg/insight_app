package com.insight.base.app.manage;

import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.Json;
import com.insight.utils.pojo.Application;
import com.insight.utils.pojo.LoginInfo;
import com.insight.utils.pojo.Reply;
import com.insight.utils.pojo.SearchDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Reply getApps(SearchDto search) {
        return service.getApps(search);
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/{id}")
    public Reply getApp(@PathVariable Long id) {
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
    public Reply newApp(@RequestHeader("loginInfo") String info, @Valid @RequestBody Application dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newApp(loginInfo, dto);
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @param dto  应用DTO
     * @return Reply
     */
    @PutMapping("/v1.0/apps/{id}")
    public Reply editApp(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Application dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        return service.editApp(loginInfo, dto);
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/apps/{id}")
    public Reply deleteApp(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.deleteApp(loginInfo, id);
    }

    /**
     * 获取导航详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/{id}/navigators")
    public Reply getNavigators(@PathVariable Long id) {
        return service.getNavigators(id);
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @GetMapping("/v1.0/navigators/{id}")
    public Reply getNavigator(@PathVariable Long id) {
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
    public Reply newNavigator(@RequestHeader("loginInfo") String info, @Valid @RequestBody Navigator dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newNavigator(loginInfo, dto);
    }

    /**
     * 编辑导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @param dto  导航DTO
     * @return Reply
     */
    @PutMapping("/v1.0/navigators/{id}")
    public Reply editNavigator(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Navigator dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        return service.editNavigator(loginInfo, dto);
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/navigators/{id}")
    public Reply deleteNavigator(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.deleteNavigator(loginInfo, id);
    }

    /**
     * 获取功能列表
     *
     * @param id 导航ID
     * @return Reply
     */
    @GetMapping("/v1.0/navigators/{id}/functions")
    public Reply getFunctions(@PathVariable Long id) {
        return service.getFunctions(id);
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @GetMapping("/v1.0/functions/{id}")
    public Reply getFunction(@PathVariable Long id) {
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
    public Reply newFunction(@RequestHeader("loginInfo") String info, @Valid @RequestBody Function dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newFunction(loginInfo, dto);
    }

    /**
     * 编辑功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @param dto  功能DTO
     * @return Reply
     */
    @PutMapping("/v1.0/functions/{id}")
    public Reply editFunction(@RequestHeader("loginInfo") String info, @PathVariable Long id, @Valid @RequestBody Function dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);
        dto.setId(id);

        return service.editFunction(loginInfo, dto);
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/functions/{id}")
    public Reply deleteFunction(@RequestHeader("loginInfo") String info, @PathVariable Long id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.deleteFunction(loginInfo, id);
    }

    /**
     * 获取日志列表
     *
     * @param search 查询实体类
     * @return Reply
     */
    @GetMapping("/v1.0/apps/logs")
    public Reply getAppLogs(SearchDto search) {
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
