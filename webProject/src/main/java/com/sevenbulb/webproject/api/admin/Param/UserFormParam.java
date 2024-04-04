package com.sevenbulb.webproject.api.admin.Param;

import lombok.Data;

@Data
public class UserFormParam {
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
    private int year_of_publication;
    private int display_contributor;
    private String other_organization;
    private String other_theme;
    private String other_type;
    private String other_languages;
    private String other_industry;
}
