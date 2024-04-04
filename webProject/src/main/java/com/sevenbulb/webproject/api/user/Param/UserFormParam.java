package com.sevenbulb.webproject.api.user.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserFormParam {
    @ApiModelProperty("标题")
    @NotEmpty(message = "标题不能为空")
    private String tool_title;

    private String type_of_tool;
    @ApiModelProperty("描述")
    @NotEmpty(message = "描述不能为空")
    private String tool_description;
    @ApiModelProperty("贡献者")
    private String contributor;
    @ApiModelProperty("邮件地址")
    @NotEmpty(message = "邮件地址不能为空")
    private String email_address;
    private String company;
    @ApiModelProperty("来源")
    @NotEmpty(message = "来源不能为空")
    private String source_of_tool;
    private String url_link_to_tool;
    private String upload_file;
    private String upload_image;
    private String industry;
    @ApiModelProperty("主题")
    @NotEmpty(message = "主题不能为空")
    private String theme;
    @ApiModelProperty("组织")
    @NotEmpty(message = "组织不能为空")
    private String organization;
    @ApiModelProperty("国家")
    @NotEmpty(message = "国家不能为空")
    private String countries;
    @ApiModelProperty("地区")
    @NotEmpty(message = "地区不能为空")
    private String region;
    @ApiModelProperty("语言")
    @NotEmpty(message = "语言不能为空")
    private String languages;
    @ApiModelProperty("种类")
    @NotEmpty(message = "种类不能为空")
    private String type;
    private int year_of_publication;
    private int display_contributor;
    private String other_organization;
    private String other_theme;
    private String other_type;
    private String other_languages;
    private String other_industry;
}
