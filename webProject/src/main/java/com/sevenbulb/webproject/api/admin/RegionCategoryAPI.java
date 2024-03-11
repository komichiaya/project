package com.sevenbulb.webproject.api.admin;


import com.sevenbulb.webproject.api.admin.Param.RegionCategoryParam;
import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.config.annotation.TokenToAdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.entity.RegionCategory;
import com.sevenbulb.webproject.service.RegionCategoryService;
import com.sevenbulb.webproject.util.BeanUtil;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/region_api/admin")
public class RegionCategoryAPI {
    private static final Logger logger = LoggerFactory.getLogger(RegionCategoryAPI.class);
    @Resource
    private RegionCategoryService regionCategoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "地区列表")
    public Result list(@RequestParam(required = false) Long countryId) {
        logger.info(":"+countryId);
        return ResultGenerator.genSuccessResult(regionCategoryService.getRegionById(countryId));
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @ApiOperation(value = "新增地区", notes = "新增地区")
    public Result save(@RequestBody @Valid RegionCategoryParam regionCategoryParam,
                       @TokenToAdminUser AdminUserToken tokenToAdminUser) {
        System.out.println("-----------"+regionCategoryParam);
        RegionCategory regionCategory = new RegionCategory();
//       BeanUtil.copyProperties(regionCategoryParam, regionCategory);
       regionCategory.setRegionName(regionCategoryParam.getRegionName());
       regionCategory.setCountryId(regionCategoryParam.getCountryId());

        String result = regionCategoryService.saveCategory(regionCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

}
