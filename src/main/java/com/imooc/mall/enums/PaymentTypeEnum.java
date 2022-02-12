package com.imooc.mall.enums;

/**
 * Created by 廖师兄
 */

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {

	PAY_ONLINE(1),
	;

	Integer code;

	PaymentTypeEnum(Integer code) {
		this.code = code;
	}
}
