package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by 廖师兄
 */
@Data
public class OrderCreateForm {

	@NotNull
	private Integer shippingId;
}
