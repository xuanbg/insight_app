package com.insight.base.app.common.entity;

import com.insight.utils.Json;
import com.insight.utils.pojo.FuncInfo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark 功能实体类
 */
public class Function implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 功能ID
     */
    private String id;

    /**
     * 导航(末级模块)ID
     */
    private String navId;

    /**
     * 功能类型 0:全局功能;1:数据项功能;2:其他功能
     */
    private Integer type;

    /**
     * 序号
     */
    private Integer index;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 接口授权码,多个授权码使用英文逗号分隔
     */
    private String authCodes;

    /**
     * 图标信息
     */
    private FuncInfo funcInfo;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    private String creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavId() {
        return navId;
    }

    public void setNavId(String navId) {
        this.navId = navId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthCodes() {
        return authCodes;
    }

    public void setAuthCodes(String authCodes) {
        this.authCodes = authCodes;
    }

    public FuncInfo getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(FuncInfo funcInfo) {
        this.funcInfo = funcInfo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
