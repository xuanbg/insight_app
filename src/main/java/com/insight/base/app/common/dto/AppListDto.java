package com.insight.base.app.common.dto;

import com.insight.utils.pojo.base.BaseXo;

/**
 * @author 宣炳刚
 * @date 2019/12/4
 * @remark 角色列表DTO
 */
public class AppListDto extends BaseXo {

    /**
     * 应用ID
     */
    private Long id;

    /**
     * 序号
     */
    private Integer index;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 应用简称
     */
    private String alias;

    /**
     * 应用域名
     */
    private String domain;

    /**
     * 授权码生命周期(毫秒)
     */
    private Integer permitLife;

    /**
     * 令牌生命周期(毫秒)
     */
    private Integer tokenLife;

    /**
     * 是否单设备登录
     */
    private Boolean isSigninOne;

    /**
     * 是否自动刷新Token
     */
    private Boolean isAutoRefresh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getPermitLife() {
        return permitLife;
    }

    public void setPermitLife(Integer permitLife) {
        this.permitLife = permitLife;
    }

    public Integer getTokenLife() {
        return tokenLife;
    }

    public void setTokenLife(Integer tokenLife) {
        this.tokenLife = tokenLife;
    }

    public Boolean getSigninOne() {
        return isSigninOne;
    }

    public void setSigninOne(Boolean signinOne) {
        isSigninOne = signinOne;
    }

    public Boolean getAutoRefresh() {
        return isAutoRefresh;
    }

    public void setAutoRefresh(Boolean autoRefresh) {
        isAutoRefresh = autoRefresh;
    }
}
