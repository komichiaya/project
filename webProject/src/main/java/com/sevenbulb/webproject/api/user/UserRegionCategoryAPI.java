package com.sevenbulb.webproject.api.user;


import com.sevenbulb.webproject.api.admin.Param.RegionCategoryParam;
import com.sevenbulb.webproject.service.RegionCategoryService;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/region_api/user")
public class UserRegionCategoryAPI {
    private static final Logger logger = LoggerFactory.getLogger(UserRegionCategoryAPI.class);
    @Resource
    private RegionCategoryService regionCategoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "地区列表")
    public Result list(RegionCategoryParam param) {
        logger.info(":"+regionCategoryService.getRegionById(param.getCountryId()));
        return ResultGenerator.genSuccessResult(regionCategoryService.getRegionById(param.getCountryId()));
    }



}
