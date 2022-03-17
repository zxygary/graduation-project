package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 */
@Data
public class OrderItemVo {

	private Long orderNo;

	private Integer productId;

	private String productName;

	private String productImage;

	private BigDecimal currentUnitPrice;

	private Integer quantity;

	private BigDecimal totalPrice;

	private Date createTime;
}
