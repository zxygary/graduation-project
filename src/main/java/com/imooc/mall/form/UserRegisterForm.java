package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
<<<<<<< HEAD
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {

//    @NotBlank 用于 String 判断空格
//    @NotNull
//    @NotEmpty 用于集合
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
=======

/**
 * Created by 廖师兄
 */
@Data
public class UserRegisterForm {

	//@NotBlank 用于 String 判断空格
	//@NotEmpty 用于集合
	//@NotNull
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String email;
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
