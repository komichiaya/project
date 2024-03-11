package com.sevenbulb.webproject.service.impl;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.dao.CountryCategortMapper;
import com.sevenbulb.webproject.entity.CountryCategory;
import com.sevenbulb.webproject.service.CountryCategoryService;
import com.sevenbulb.webproject.util.PageQueryUtil;
import com.sevenbulb.webproject.util.PageResult;
import com.sevenbulb.webproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCategoryServiceImpl implements CountryCategoryService {
    @Autowired
    private CountryCategortMapper countryCategortMapper;
    @Override
    public String saveCategory(CountryCategory countryCategory){
        CountryCategory temp = countryCategortMapper.selectByCountryName(countryCategory.getCountryName());
        if(temp != null){
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if(countryCategortMapper.insertSelective(countryCategory) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public CountryCategory getCountryById(Long id) {
        return countryCategortMapper.selectByCountryId(id);
    }

    @Override
    public List<CountryCategory> getCountryPage() {
        List<CountryCategory> countryCategories = countryCategortMapper.getCountryList();
        //int total = countryCategortMapper.getTotalCountryCount();
        return  countryCategories;
    }



}
