package com.sevenbulb.webproject.entity;

import lombok.Data;

@Data
public class RegionCategory {
    private Long regionId;
    private Long countryId;
    private String regionName;
}
