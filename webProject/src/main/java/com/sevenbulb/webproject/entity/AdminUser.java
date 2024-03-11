package com.sevenbulb.webproject.entity;

import lombok.Data;

@Data
public class AdminUser {
    private Long adminUserId;

    private String loginUserName;

    private String loginPassword;
}
