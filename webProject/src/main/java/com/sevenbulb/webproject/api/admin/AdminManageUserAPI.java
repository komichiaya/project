package com.sevenbulb.webproject.api.admin;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.config.annotation.TokenToAdminUser;
import com.sevenbulb.webproject.api.admin.Param.AdminLoginParam;
import com.sevenbulb.webproject.entity.AdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.service.AdminUserService;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import com.sevenbulb.webproject.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/admin")
public class AdminManageUserAPI {
    @Resource
    private AdminUserService adminUserService;
    private static final Logger logger = LoggerFactory.getLogger(AdminManageUserAPI.class);

    @RequestMapping(value = "/adminUser/login",method = RequestMethod.POST)
    public Result<String> login(@RequestBody @Valid AdminLoginParam adminLoginParam){
        String loginResult = adminUserService.login(adminLoginParam.getUser_name(),adminLoginParam.getUser_password());
        logger.info("manage login api,adminName={},loginResult={}",adminLoginParam.getUser_name(),loginResult);
        //登录成功
        if(StringUtils.hasLength(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH){
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);

            return result;
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }
    @RequestMapping(value = "/adminUser/profile", method = RequestMethod.GET)
    public Result profile(@TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        AdminUser adminUserEntity = adminUserService.getUserDetailById(adminUser.getAdminUserId());
        logger.info("adminUserEntity={}",adminUserEntity);

        if (adminUserEntity != null) {
            adminUserEntity.setLoginPassword("******");
            Result result = ResultGenerator.genSuccessResult();
            result.setData(adminUserEntity);
            return result;
        }
        return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
    }

    @RequestMapping(value = "/adminUser/logout", method = RequestMethod.DELETE)
    public Result logout(@TokenToAdminUser AdminUserToken adminUser) {
        System.out.println(adminUser);
        logger.info("adminUser:{}", adminUser.toString());
        adminUserService.logout(adminUser.getAdminUserId());
        return ResultGenerator.genSuccessResult();
    }


}
