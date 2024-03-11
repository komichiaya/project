package com.sevenbulb.webproject.api.user.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class CountryCategoryParam implements Serializable {
    @ApiModelProperty("国家名")
    @NotEmpty(message = "国家名不能为空")
    private String countryName;
}
