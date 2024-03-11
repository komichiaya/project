package com.sevenbulb.webproject.api.user.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserFormParam {
    @ApiModelProperty("标题")
    @NotEmpty(message = "标题不能为空")
    private String Title;

    @ApiModelProperty("描述")
    @NotEmpty(message = "描述不能为空")
    private String Description;

    @ApiModelProperty("贡献者")
    private String Contributor;

    @ApiModelProperty("邮件地址")
    @NotEmpty(message = "邮件地址不能为空")
    private String Email;
    @ApiModelProperty("来源")
    @NotEmpty(message = "来源不能为空")
    private String Source;

    private String URL;
    private String ImgFile;

    private String ToolFile;

    private String Thumbnail;

    private String Industry;
    @ApiModelProperty("种类")
    @NotEmpty(message = "种类不能为空")
    private String Type;
    @ApiModelProperty("主题")
    @NotEmpty(message = "主题不能为空")
    private String Themes;
    @ApiModelProperty("组织")
    @NotEmpty(message = "组织不能为空")
    private String Organizations;
    @ApiModelProperty("国家")
    @NotEmpty(message = "国家不能为空")
    private String Country;
    @ApiModelProperty("地区")
    @NotEmpty(message = "地区不能为空")
    private String Region;
    @ApiModelProperty("语言")
    @NotEmpty(message = "语言不能为空")
    private String Language;

}
