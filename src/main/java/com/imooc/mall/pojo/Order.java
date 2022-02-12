package com.imooc.mall.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
<<<<<<< HEAD
=======

>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
@Data
public class Order {
    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer shippingId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;
<<<<<<< HEAD

=======
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}