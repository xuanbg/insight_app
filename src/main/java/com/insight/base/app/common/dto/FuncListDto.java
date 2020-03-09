package com.insight.base.app.common.dto;

import com.insight.util.Json;
import com.insight.util.pojo.FuncInfo;

import java.io.Serializable;

/**
 * @author 宣炳刚
 * @date 2019/12/12
 * @remark 功能列表类
 */
public class FuncListDto implements Serializable {
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

    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
