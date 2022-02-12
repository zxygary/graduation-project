package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * Created by 廖师兄
 */
@Data
public class CartAddForm {

	@NotNull
	private Integer productId;

	private Boolean selected = true;
}
