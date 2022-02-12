package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

<<<<<<< HEAD
@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
=======
/**
 * Created by 廖师兄
 */
@Data
public class UserLoginForm {

	@NotBlank
	private String username;

	@NotBlank
	private String password;
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
