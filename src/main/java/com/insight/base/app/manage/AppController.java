package com.insight.base.app.manage;

import com.insight.base.app.common.client.LogClient;
import com.insight.base.app.common.client.LogServiceClient;
import com.insight.base.app.common.dto.FuncListDto;
import com.insight.base.app.common.dto.NavListDto;
import com.insight.base.app.common.entity.Function;
import com.insight.base.app.common.entity.Navigator;
import com.insight.base.app.common.entity.OperateType;
import com.insight.utils.Json;
import com.insight.utils.pojo.app.Application;
import com.insight.utils.pojo.auth.LoginInfo;
import com.insight.utils.pojo.base.Reply;
import com.insight.utils.pojo.base.Search;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 宣炳刚
 * @date 2019/12/11
 * @remark 应用管理服务控制器
 */
@RestController
@RequestMapping("/base/resource")
public class AppController {
    private static final String BUSINESS = "Resource";
    private final LogServiceClient client;
    private final AppService service;

    /**
     * 构造方法
     *
     * @param client Feign客户端
     * @param service 自动注入的Service
     */
    public AppController(LogServiceClient client, AppService service) {
        this.client = client;
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
     * @param loginInfo 用户关键信息
     * @param dto  应用DTO
     * @return Reply
     */
    @PostMapping("/v1.0/apps")
    public Long newApp(@RequestHeader("loginInfo") String loginInfo, @Valid @RequestBody Application dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        var id = service.newApp(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.NEW, id, dto);
        return id;
    }

    /**
     * 编辑应用
     *
     * @param loginInfo 用户关键信息
     * @param id   应用ID
     * @param dto  应用DTO
     */
    @PutMapping("/v1.0/apps/{id}")
    public void editApp(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id, @Valid @RequestBody Application dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);
        dto.setId(id);

        service.editApp(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.EDIT, id, dto);
    }

    /**
     * 删除应用
     *
     * @param loginInfo 用户关键信息
     * @param id   应用ID
     */
    @DeleteMapping("/v1.0/apps/{id}")
    public void deleteApp(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        service.deleteApp(info, id);
        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, null);
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
     * @param loginInfo 用户关键信息
     * @param dto  导航DTO
     * @return Reply
     */
    @PostMapping("/v1.0/navigators")
    public Long newNavigator(@RequestHeader("loginInfo") String loginInfo, @Valid @RequestBody Navigator dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        var id = service.newNavigator(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.NEW, id, dto);
        return id;
    }

    /**
     * 编辑导航
     *
     * @param loginInfo 用户关键信息
     * @param id   导航ID
     * @param dto  导航DTO
     */
    @PutMapping("/v1.0/navigators/{id}")
    public void editNavigator(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id, @Valid @RequestBody Navigator dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);
        dto.setId(id);

        service.editNavigator(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.EDIT, id, dto);
    }

    /**
     * 删除导航
     *
     * @param loginInfo 用户关键信息
     * @param id   导航ID
     */
    @DeleteMapping("/v1.0/navigators/{id}")
    public void deleteNavigator(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        service.deleteNavigator(info, id);
        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, null);
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
     * @param loginInfo 用户关键信息
     * @param dto  功能DTO
     * @return Reply
     */
    @PostMapping("/v1.0/functions")
    public Long newFunction(@RequestHeader("loginInfo") String loginInfo, @Valid @RequestBody Function dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        var id = service.newFunction(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.NEW, id, dto);
        return id;
    }

    /**
     * 编辑功能
     *
     * @param loginInfo 用户关键信息
     * @param id   功能ID
     * @param dto  功能DTO
     */
    @PutMapping("/v1.0/functions/{id}")
    public void editFunction(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id, @Valid @RequestBody Function dto) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);
        dto.setId(id);

        service.editFunction(info, dto);
        LogClient.writeLog(info, BUSINESS, OperateType.EDIT, id, dto);
    }

    /**
     * 删除功能
     *
     * @param loginInfo 用户关键信息
     * @param id   功能ID
     */
    @DeleteMapping("/v1.0/functions/{id}")
    public void deleteFunction(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id) {
        LoginInfo info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);

        service.deleteFunction(info, id);
        LogClient.writeLog(info, BUSINESS, OperateType.DELETE, id, null);
    }

    /**
     * 查询日志
     *
     * @param loginInfo 用户登录信息
     * @param search    查询条件
     * @return 日志集合
     */
    @GetMapping("/v1.0/apps/{id}/logs")
    public Reply getAirportLogs(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id, Search search) {
        var info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);
        return client.getLogs(id, "Resource", search.getKeyword());
    }

    /**
     * 获取日志
     *
     * @param loginInfo 用户登录信息
     * @param id        日志ID
     * @return 日志VO
     */
    @GetMapping("/v1.0/apps/logs/{id}")
    public Reply getAirportLog(@RequestHeader("loginInfo") String loginInfo, @PathVariable Long id) {
        var info = Json.toBeanFromBase64(loginInfo, LoginInfo.class);
        return client.getLog(id);
    }
}
