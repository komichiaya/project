package com.sevenbulb.webproject.service.impl;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.dao.RegionCategoryMapper;
import com.sevenbulb.webproject.entity.RegionCategory;
import com.sevenbulb.webproject.service.RegionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionCategoryServiceImpl implements RegionCategoryService {
    @Autowired
    private RegionCategoryMapper regionCategoryMapper;
    @Override
    public String saveCategory(RegionCategory region) {
        System.out.println("-----------"+region.toString());
        RegionCategory temp = regionCategoryMapper.selectByRegionName(region.getRegionName());
        System.out.println("-------------"+temp);
        if(temp != null){
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if(regionCategoryMapper.insertSelective(region) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public RegionCategory getRegionById(Long id) {
        return regionCategoryMapper.selectByRegionId(id);
    }

    @Override
    public List<RegionCategory> getRegionPage() {
        List<RegionCategory> regionCategories = regionCategoryMapper.getRegionList();
        return regionCategories;
    }
}
