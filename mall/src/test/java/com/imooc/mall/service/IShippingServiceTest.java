package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by 廖师兄
 */
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

	@Autowired
	private IShippingService shippingService;

	private Integer uid = 1;

	private ShippingForm form;

	private Integer shippingId;

	@Before
	public void before() {
		ShippingForm form = new ShippingForm();
		form.setReceiverName("廖师兄");
		form.setReceiverAddress("慕课网");
		form.setReceiverCity("北京");
		form.setReceiverMobile("18812345678");
		form.setReceiverPhone("010123456");
		form.setReceiverProvince("北京");
		form.setReceiverDistrict("海淀区");
		form.setReceiverZip("000000");
		this.form = form;

		add();
	}

	public void add() {
		ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
		log.info("result={}", responseVo);
		this.shippingId = responseVo.getData().get("shippingId");
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@After
	public void delete() {
		ResponseVo responseVo = shippingService.delete(uid, shippingId);
		log.info("result={}", responseVo);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void update() {
		form.setReceiverCity("杭州");
		ResponseVo responseVo = shippingService.update(uid, shippingId, form);
		log.info("result={}", responseVo);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void list() {
		ResponseVo responseVo = shippingService.list(uid, 1, 10);
		log.info("result={}", responseVo);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}