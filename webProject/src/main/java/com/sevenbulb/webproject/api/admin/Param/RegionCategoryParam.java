package com.sevenbulb.webproject.api.admin.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RegionCategoryParam implements Serializable {
    @ApiModelProperty("地区名")
    @NotEmpty(message = "地区名不能为空")
    private String regionName;
    @ApiModelProperty("国家ID")
    @NotNull(message = "国家ID不能为空")
    private Long countryId;
}
