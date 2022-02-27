package com.service;

import com.imooc.mall.MallApplicationTests;
import mall.enums.ResponseEnum;
import mall.service.ICategoryService;
import mall.vo.CategoryVo;
import mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CategoryServiceTest extends MallApplicationTests {

	@Autowired
	private ICategoryService categoryService;

	@Test
	public void selectAll() {
		ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void findSubCategoryId() {
		Set<Integer> set = new HashSet<>();
		categoryService.findSubCategoryId(100001, set);
		log.info("set={}", set);
	}
}