package com.example.server.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginParams
{
	@ApiModelProperty(value = "用户名",required = true)
	private String username;
	@ApiModelProperty(value = "密码",required = true)
	private String password;
	@ApiModelProperty(value = "验证码",required = true)
	private String captcha;
}
