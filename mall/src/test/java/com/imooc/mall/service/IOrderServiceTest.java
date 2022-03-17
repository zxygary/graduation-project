package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 廖师兄
 */
@Slf4j
@Transactional
public class IOrderServiceTest extends MallApplicationTests {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private ICartService cartService;

	private Integer uid = 1;

	private Integer shippingId = 4;

	private Integer productId = 26;

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Before
	public void before() {
		CartAddForm form = new CartAddForm();
		form.setProductId(productId);
		form.setSelected(true);
		ResponseVo<CartVo> responseVo = cartService.add(uid, form);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void createTest() {
		ResponseVo<OrderVo> responseVo = create();
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	private ResponseVo<OrderVo> create() {
		ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
		log.info("result={}", gson.toJson(responseVo));
		return responseVo;
	}

	@Test
	public void list() {
		ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 4);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void detail() {
		ResponseVo<OrderVo> vo = create();
		ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void cancel() {
		ResponseVo<OrderVo> vo = create();
		ResponseVo responseVo = orderService.cancel(uid, vo.getData().getOrderNo());
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}