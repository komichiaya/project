package com.sevenbulb.webproject.api.user;

import com.sevenbulb.webproject.api.admin.Param.CountryCategoryParam;
import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.entity.CountryCategory;
import com.sevenbulb.webproject.service.CountryCategoryService;
import com.sevenbulb.webproject.util.BeanUtil;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/country_api/user")
public class UserCountryCategoryAPI {
    private static final Logger logger = LoggerFactory.getLogger(UserCountryCategoryAPI.class);
    @Resource
    private CountryCategoryService countryCategoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "国家列表")
    public Result list() {
        return ResultGenerator.genSuccessResult(countryCategoryService.getCountryPage());
    }



}
