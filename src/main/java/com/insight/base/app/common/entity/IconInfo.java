package com.insight.base.app.common.entity;

import com.insight.util.Json;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark
 */
public class IconInfo {
    private static final long serialVersionUID = -1L;

    /**
     * 功能图标
     */
    private String icon;

    /**
     * 是否开始分组
     */
    private Boolean isBeginGroup;

    /**
     * 是否隐藏文字
     */
    private Boolean isHideText;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getBeginGroup() {
        return isBeginGroup;
    }

    public void setBeginGroup(Boolean beginGroup) {
        isBeginGroup = beginGroup;
    }

    public Boolean getHideText() {
        return isHideText;
    }

    public void setHideText(Boolean hideText) {
        isHideText = hideText;
    }

    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
