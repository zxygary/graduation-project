package com.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.MallApplicationTests;
import mall.enums.ResponseEnum;
import mall.service.IProductService;
import mall.vo.ProductDetailVo;
import mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 廖师兄
 */
public class IProductServiceTest extends MallApplicationTests {

	@Autowired
	private IProductService productService;

	@Test
	public void list() {
		ResponseVo<PageInfo> responseVo = productService.list(null, 2, 3);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void detail() {
		ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}