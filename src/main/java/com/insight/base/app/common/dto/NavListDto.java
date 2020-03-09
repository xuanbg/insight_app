package com.insight.base.app.common.dto;

import com.insight.util.Json;
import com.insight.util.pojo.ModuleInfo;

import java.io.Serializable;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark 导航列表实体类
 */
public class NavListDto implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 导航ID
     */
    private String id;

    /**
     * 父级导航ID
     */
    private String parentId;

    /**
     * 应用ID
     */
    private String appId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
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

    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
