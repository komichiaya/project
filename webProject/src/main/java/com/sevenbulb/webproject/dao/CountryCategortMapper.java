package com.sevenbulb.webproject.dao;

import com.sevenbulb.webproject.entity.CountryCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryCategortMapper {
    int deleteByCountryId(Long countryId);
    int insert(CountryCategory country);
    int insertSelective(CountryCategory country);
    CountryCategory selectByCountryId(Long countryId);
    CountryCategory selectByCountryName(@Param("countryName") String countryName);
    int updataByCountryIdSelective(CountryCategory country);
    int updataByCountryId(CountryCategory country);
    List<CountryCategory> getCountryList();
    int getTotalCountryCount();
}
