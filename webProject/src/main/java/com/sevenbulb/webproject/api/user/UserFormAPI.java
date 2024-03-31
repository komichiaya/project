package com.sevenbulb.webproject.api.user;

import com.sevenbulb.webproject.api.user.Param.UserFormParam;
import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.config.annotation.TokenToAdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import com.sevenbulb.webproject.entity.UserForm;
import com.sevenbulb.webproject.service.UserFormService;
import com.sevenbulb.webproject.util.BeanUtil;
import com.sevenbulb.webproject.util.MyUtils;
import com.sevenbulb.webproject.util.Result;
import com.sevenbulb.webproject.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserFormAPI {
    private static final Logger logger = LoggerFactory.getLogger(UserFormAPI.class);
    private final static String FILE_UPLOAD_PATH = "D:\\upload\\";
    @Resource
    private UserFormService userFormService;
//    private NewBeeMallCategoryService newBeeMallCategoryService;

    /**
     * 添加
     */

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ApiOperation(value = "新增表单", notes = "新增表单")
    public Result save(HttpServletRequest httpServletRequest,
                       @Valid UserFormParam userFormParam,
                       @RequestParam(required = false, value = "img") MultipartFile img,
                       @RequestParam(required = false, value = "tool") MultipartFile tool) {
        if(img != null || tool!= null){
            String imgName = img.getOriginalFilename();
            String toolName = tool.getOriginalFilename();

            String suffixName = imgName.substring(imgName.lastIndexOf("."));
            String suffixName1 = toolName.substring(toolName.lastIndexOf("."));

            //生成文件名称通用方法
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random r = new Random();




            StringBuilder tempName = new StringBuilder();
            StringBuilder tempName1 = new StringBuilder();

            tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
            tempName1.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName1);

            String newFileName = tempName.toString();
            String newFileName1 = tempName1.toString();

            File fileDirectory = new File(FILE_UPLOAD_PATH);
            //创建文件
            File destFile = new File(FILE_UPLOAD_PATH + newFileName);
            File destFile1 = new File(FILE_UPLOAD_PATH + newFileName1);

            try {
                if (!fileDirectory.exists()) {
                    if (!fileDirectory.mkdir()) {
                        throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                    }
                }
                img.transferTo(destFile);
                tool.transferTo(destFile1);

                Result resultSuccess = ResultGenerator.genSuccessResult();
                Result resultSuccess1 = ResultGenerator.genSuccessResult();

                resultSuccess.setData(MyUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) +
                        "/upload/" + newFileName);
                resultSuccess1.setData(MyUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) +
                        "/upload/" + newFileName1);

                UserForm userForm = new UserForm();
                BeanUtil.copyProperties(userFormParam, userForm);

                userForm.setImgFile((String) resultSuccess.getData());
                userForm.setToolFile((String) resultSuccess1.getData());
                logger.info("userForm:"+userForm.getCreateTime());

                String result = userFormService.saveUserForm(userForm);
                if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
                    return ResultGenerator.genSuccessResult();
                } else {
                    return ResultGenerator.genFailResult(result);
                }
//            return resultSuccess;
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return ResultGenerator.genFailResult("文件上传失败");
            }
        }else{
            UserForm userForm = new UserForm();
            BeanUtil.copyProperties(userFormParam, userForm);
            logger.info("userForm:"+userForm.getCreateTime());
            String result = userFormService.saveUserForm(userForm);
            if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult(result);
            }
        }

    }
}

//    @RequestMapping(value = "/submit", method = RequestMethod.POST)
//    @ApiOperation(value = "新增表单", notes = "新增表单")
//    public Result save(@RequestBody @Valid UserFormParam userFormParam) {
////        logger.info("adminUser:{}", adminUser.toString());
//        UserForm userForm = new UserForm();
//        BeanUtil.copyProperties(userFormParam, userForm);
//        String result = userFormService.saveUserForm(userForm);
//        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult(result);
//        }
//    }


