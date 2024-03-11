package com.sevenbulb.webproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserForm {
    private Long FormId;
    private String Title;
    private String Description;
    private String Contributor;
    private String Email;
    private String Source;
    private String URL;
    private String ToolFile;
    private String Thumbnail;
    private String Type;
    private String Industry;
    private String Themes;
    private String Organizations;
    private String Country;
    private String Region;
    private String Language;
    private int ReviewType;
    private String ImgFile;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
