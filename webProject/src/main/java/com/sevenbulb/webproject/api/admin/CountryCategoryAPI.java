package com.sevenbulb.webproject.api.admin;

import com.sevenbulb.webproject.api.admin.Param.CountryCategoryParam;
import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.config.annotation.TokenToAdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.entity.CountryCategory;
import com.sevenbulb.webproject.service.CountryCategoryService;
import com.sevenbulb.webproject.util.BeanUtil;
import com.sevenbulb.webproject.util.PageQueryUtil;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;



@RestController
@RequestMapping("/country_api/admin")
public class CountryCategoryAPI {
    private static final Logger logger = LoggerFactory.getLogger(CountryCategoryAPI.class);
    @Resource
    private CountryCategoryService countryCategoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "国家列表")
    public Result list(@TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        return ResultGenerator.genSuccessResult(countryCategoryService.getCountryPage());

    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @ApiOperation(value = "新增国家", notes = "新增国家")
    public Result save(@RequestBody @Valid CountryCategoryParam countryCategoryParam,
                       @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        CountryCategory countryCategory = new CountryCategory();
        BeanUtil.copyProperties(countryCategoryParam, countryCategory);
        String result = countryCategoryService.saveCategory(countryCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

}
