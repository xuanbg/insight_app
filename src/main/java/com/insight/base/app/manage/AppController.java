package com.insight.base.app.manage;

import com.insight.base.app.common.entity.App;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.utils.Json;
import com.insight.utils.ReplyHelper;
import com.insight.utils.pojo.LoginInfo;
import com.insight.utils.pojo.Reply;
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
     * @param keyword 查询关键词
     * @param page    分页页码
     * @param size    每页记录数
     * @return Reply
     */
    @GetMapping("/v1.0/apps")
    public Reply getApps(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        return service.getApps(keyword, page, size);
    }

    /**
     * 获取应用详情
     *
     * @param id 应用ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/{id}")
    public Reply getApp(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

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
    public Reply newApp(@RequestHeader("loginInfo") String info, @Valid @RequestBody App dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.newApp(loginInfo, dto);
    }

    /**
     * 编辑应用
     *
     * @param info 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @PutMapping("/v1.0/apps")
    public Reply editApp(@RequestHeader("loginInfo") String info, @Valid @RequestBody App dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.editApp(loginInfo, dto);
    }

    /**
     * 删除应用
     *
     * @param info 用户关键信息
     * @param id   应用ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/apps")
    public Reply deleteApp(@RequestHeader("loginInfo") String info, @RequestBody String id) {
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
    public Reply getNavigators(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

        return service.getNavigators(id);
    }

    /**
     * 获取导航详情
     *
     * @param id 导航ID
     * @return Reply
     */
    @GetMapping("/v1.0/navigators/{id}")
    public Reply getNavigator(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

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
     * @param dto  导航DTO
     * @return Reply
     */
    @PutMapping("/v1.0/navigators")
    public Reply editNavigator(@RequestHeader("loginInfo") String info, @Valid @RequestBody Navigator dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.editNavigator(loginInfo, dto);
    }

    /**
     * 删除导航
     *
     * @param info 用户关键信息
     * @param id   导航ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/navigators")
    public Reply deleteNavigator(@RequestHeader("loginInfo") String info, @RequestBody String id) {
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
    public Reply getFunctions(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

        return service.getFunctions(id);
    }

    /**
     * 获取功能详情
     *
     * @param id 功能ID
     * @return Reply
     */
    @GetMapping("/v1.0/functions/{id}")
    public Reply getFunction(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

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
     * @param dto  功能DTO
     * @return Reply
     */
    @PutMapping("/v1.0/functions")
    public Reply editFunction(@RequestHeader("loginInfo") String info, @Valid @RequestBody Function dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.editFunction(loginInfo, dto);
    }

    /**
     * 删除功能
     *
     * @param info 用户关键信息
     * @param id   功能ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/functions")
    public Reply deleteFunction(@RequestHeader("loginInfo") String info, @RequestBody String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.deleteFunction(loginInfo, id);
    }

    /**
     * 获取日志列表
     *
     * @param keyword 查询关键词
     * @param page    分页页码
     * @param size    每页记录数
     * @return Reply
     */
    @GetMapping("/v1.0/apps/logs")
    public Reply getAppLogs(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        return service.getAppLogs(keyword, page, size);
    }

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @GetMapping("/v1.0/apps/logs/{id}")
    public Reply getAppLog(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ReplyHelper.invalidParam();
        }

        return service.getAppLog(id);
    }
}
