package com.sevenbulb.webproject.service.impl;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.dao.AdminUserMapper;
import com.sevenbulb.webproject.dao.AdminUserTokenMapper;
import com.sevenbulb.webproject.entity.AdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.service.AdminUserService;
import com.sevenbulb.webproject.util.NumberUtil;
import com.sevenbulb.webproject.util.SystemUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;
    @Resource
    private AdminUserTokenMapper adminUserTokenMapper;



    @Override
    public Boolean logout(Long adminUserId) {
        return adminUserTokenMapper.deleteByPrimaryKey(adminUserId) > 0;
    }

    @Override
    public String login(String username, String password) {
        AdminUser loginAdminUser = adminUserMapper.login(username, password);
        System.out.println("----"+loginAdminUser.getAdminUserId()+"-----");
        if (loginAdminUser != null) {
            String token = getNewToken(System.currentTimeMillis() + "", loginAdminUser.getAdminUserId());
            AdminUserToken adminUserToken = adminUserTokenMapper.selectByPrimaryKey(loginAdminUser.getAdminUserId());
            Date now = new Date();
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);
            if (adminUserToken == null) {
                adminUserToken = new AdminUserToken();
                adminUserToken.setAdminUserId(loginAdminUser.getAdminUserId());
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expireTime);
                if (adminUserTokenMapper.insertSelective(adminUserToken) > 0) {
                    return token;
                }
            } else {
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expireTime);
                if (adminUserTokenMapper.updateByPrimaryKeySelective(adminUserToken) > 0) {
                    return token;
                }
            }

        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    private String getNewToken(String timeStr, Long userId) {
        String src = timeStr + userId + NumberUtil.genRandomNum(6);
        return SystemUtil.genToken(src);
    }
}
