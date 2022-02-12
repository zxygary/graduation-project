package com.imooc.mall.service;

import com.imooc.mall.vo.ProductVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * Created by 廖师兄
 */
public interface IProductService {

	ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
