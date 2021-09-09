package com.example.bdz.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author zhn
 * @Date 2021/9/9 14:53
 * @Version 1.0
 */
@Data
public class PasswordDto implements Serializable {
    @NotBlank(message = "新密码不能为空")
    private String pwd;
    @NotBlank(message = "旧密码不能为空")
    private String currentPwd;
}
