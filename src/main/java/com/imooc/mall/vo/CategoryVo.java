package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by 廖师兄
 */
@Data
public class CategoryVo {

	private Integer id;

	private Integer parentId;

	private String name;

	private Integer sortOrder;

	private List<CategoryVo> subCategories;
}
