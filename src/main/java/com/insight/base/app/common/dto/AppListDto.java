package com.insight.base.app.common.dto;

import com.insight.util.Json;

import java.io.Serializable;

/**
 * @author 宣炳刚
 * @date 2019/12/4
 * @remark 角色列表DTO
 */
public class AppListDto implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * ID
     */
    private String id;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 级别:0.应用;1.一级导航;2.二级导航;3.功能
     */
    private Integer type;

    /**
     * 序号
     */
    private Integer index;

    /**
     * 名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
