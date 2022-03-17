package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 * Created by 廖师兄
 */
@Data
public class CartVo {

	private List<CartProductVo> cartProductVoList;

	private Boolean selectedAll;

	private BigDecimal cartTotalPrice;

	private Integer cartTotalQuantity;
}
