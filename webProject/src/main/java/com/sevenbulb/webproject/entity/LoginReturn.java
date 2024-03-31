package com.sevenbulb.webproject.entity;

import lombok.Data;

@Data
public class LoginReturn {
    private String token;
    private int level;
}
