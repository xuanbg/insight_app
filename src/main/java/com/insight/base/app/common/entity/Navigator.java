package com.insight.base.app.common.entity;

import com.insight.utils.pojo.app.ModuleInfo;
import com.insight.utils.pojo.base.BaseXo;

import java.time.LocalDateTime;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark 导航实体类
 */
public class Navigator extends BaseXo {

    /**
     * 导航ID
     */
    private Long id;

    /**
     * 父级导航ID
     */
    private Long parentId;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 导航级别
     */
    private Integer type;

    /**
     * 序号
     */
    private Integer index;

    /**
     * 导航名称
     */
    private String name;

    /**
     * 模块信息
     */
    private ModuleInfo moduleInfo;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
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

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
