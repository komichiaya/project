package com.sevenbulb.webproject.service;

import com.sevenbulb.webproject.entity.AdminUser;

public interface AdminUserService {
    //    登录
    String login(String username, String password);
    //登出
    Boolean logout(Long adminUserId);
    AdminUser getUserDetailById(Long loginUserId);
}
