package com.sevenbulb.webproject.service;

import com.sevenbulb.webproject.entity.RegionCategory;

import java.util.List;

public interface RegionCategoryService {
    String saveCategory(RegionCategory region);
    RegionCategory getRegionById(Long id);
    List<RegionCategory> getRegionPage();
}
