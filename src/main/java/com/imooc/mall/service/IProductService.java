package com.imooc.mall.service;

<<<<<<< HEAD
import com.imooc.mall.vo.ProductVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

public interface IProductService {

    ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);
=======
import com.github.pagehelper.PageInfo;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * Created by 廖师兄
 */
public interface IProductService {

	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

	ResponseVo<ProductDetailVo> detail(Integer productId);
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
