package com.sevenbulb.webproject.service;

public interface AdminUserService {
    //    登录
    String login(String username, String password);
    //登出
    Boolean logout(Long adminUserId);

}
