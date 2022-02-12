package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

<<<<<<< HEAD
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
=======
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
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
