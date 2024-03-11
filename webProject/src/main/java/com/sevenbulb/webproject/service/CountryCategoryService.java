package com.sevenbulb.webproject.service;

import com.sevenbulb.webproject.entity.CountryCategory;
import com.sevenbulb.webproject.util.PageQueryUtil;
import com.sevenbulb.webproject.util.PageResult;

import java.util.List;

public interface CountryCategoryService {
    String saveCategory(CountryCategory countryCategory);
    CountryCategory getCountryById(Long id);
    List<CountryCategory> getCountryPage();
}
