package com.sevenbulb.webproject.api.admin.Param;

import lombok.Data;

@Data
public class UserFormParam {
    private Long formId;
    private String title;
    private String description;
    private String contributor;
    private String email;
    private String source;
    private String url;
    private String toolFile;
    private String thumbnail;
    private String type;
    private String industry;
    private String themes;
    private String organizations;
    private String country;
    private String region;
    private String language;
    private int year_of_publication;
    private int display_contributor;
    private String other_organization;
    private String other_theme;
    private String other_type;
    private String other_languages;
    private String other_industry;
}
