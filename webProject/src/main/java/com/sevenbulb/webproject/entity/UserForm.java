package com.sevenbulb.webproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserForm {
    private Long id;
    private String tool_title;
    private String type_of_tool;
    private String tool_description;
    private String contributor;
    private String email_address;
    private String company;
    private String source_of_tool;
    private String url_link_to_tool;
    private String upload_file;
    private String upload_image;
    private String industry;
    private String theme;
    private String organization;
    private String countries;
    private String region;
    private String languages;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;
    private int approval_status;
    private int year_of_publication;
    private int display_contributor;
    private String other_organization;
    private String other_theme;
    private String other_type;
    private String other_languages;
    private String other_industry;


}
