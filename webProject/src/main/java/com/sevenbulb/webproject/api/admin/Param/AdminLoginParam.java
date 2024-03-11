package com.sevenbulb.webproject.api.admin.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AdminLoginParam  implements Serializable {
    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String user_name;
    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String user_password;
}
