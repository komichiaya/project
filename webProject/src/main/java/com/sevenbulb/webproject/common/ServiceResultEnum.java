/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package com.sevenbulb.webproject.common;

public enum ServiceResultEnum {
    ERROR("error"),

    SUCCESS("success"),

    DATA_NOT_EXIST("未查询到记录！"),


    LOGIN_ERROR("登录失败！"),

    NOT_LOGIN_ERROR("未登录！"),

    ADMIN_NOT_LOGIN_ERROR("管理员未登录！"),

    TOKEN_EXPIRE_ERROR("无效认证！请重新登录！"),

    ADMIN_TOKEN_EXPIRE_ERROR("管理员登录过期！请重新登录！"),

    USER_NULL_ERROR("无效用户！请重新登录！"),

    LOGIN_USER_LOCKED_ERROR("用户已被禁止登录！"),

    NULL_ADDRESS_ERROR("地址不能为空！"),

    OPERATE_ERROR("操作失败！"),

    REQUEST_FORBIDEN_ERROR("禁止该操作！"),

    NO_PERMISSION_ERROR("无权限！"),

    DB_ERROR("database error");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
