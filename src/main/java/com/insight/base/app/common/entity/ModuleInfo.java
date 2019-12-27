package com.insight.base.app.common.entity;

import com.insight.util.Json;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark
 */
public class ModuleInfo {
    private static final long serialVersionUID = -1L;

    /**
     * 模块名称
     */
    private String module;

    /**
     * 文件名
     */
    private String file;

    /**
     * 是否默认加载模块
     */
    private Boolean isDefault;

    /**
     * 模块图标
     */
    private String icon;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
