package com.sevenbulb.webproject.dao;

import com.sevenbulb.webproject.entity.RegionCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionCategoryMapper {
    int insert(RegionCategory region);
    int insertSelective(RegionCategory region);
    RegionCategory selectByRegionId(Long countryId);
    RegionCategory selectByRegionName(@Param("regionName") String regionName);
   List<RegionCategory> getRegionList();
    int getTotalRegionCount();

}
