package com.sevenbulb.webproject.api.admin;

import com.sevenbulb.webproject.api.admin.Param.UserFormParam;
import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.config.annotation.TokenToAdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.entity.UserForm;
import com.sevenbulb.webproject.service.AdminReviewFormService;
import com.sevenbulb.webproject.util.BeanUtil;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminReviewFormAPI {
    private static final Logger logger = LoggerFactory.getLogger(AdminReviewFormAPI.class);
    @Resource
    private AdminReviewFormService adminReviewFormService;
    public final static int FORM_REVIEW_TYPE_DOWN = 0;
    public final static int FORM_REVIEW_TYPE_UP = 1;

    /**
     * 修改
     */
    @RequestMapping(value = "/form", method = RequestMethod.PUT)
    @ApiOperation(value = "修改表单信息", notes = "修改表单信息")
    public Result update(@RequestBody @Valid UserFormParam userFormParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        logger.info("123"+userFormParam.toString());
        UserForm userForm = new UserForm();
        BeanUtil.copyProperties(userFormParam, userForm);
        String result = adminReviewFormService.updateFormInfo(userForm);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
    /**
     * 列表
     */
    @RequestMapping(value = "/form/list", method = RequestMethod.GET)
    @ApiOperation(value = "表单列表")
    public Result list(@TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        return ResultGenerator.genSuccessResult(adminReviewFormService.getFormInfoPage());
    }

    /**
     * 修改审核状态
     */
    @RequestMapping(value = "/form/status/{formStatus}", method = RequestMethod.PUT)
    @ApiOperation(value = "审核", notes = "审核")
    public Result delete(@RequestParam Long formId,
                         @PathVariable("formStatus") int formStatus,
                         @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        logger.info("321:"+formId);
        if (formId == null || formId < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (formStatus != FORM_REVIEW_TYPE_DOWN && formStatus != FORM_REVIEW_TYPE_UP) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (adminReviewFormService.batchUpdateReviewStatus(formId,formStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }


}

