package mall.service;

import com.github.pagehelper.PageInfo;
import mall.vo.ProductDetailVo;
import mall.vo.ResponseVo;

public interface IProductService {

	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

	ResponseVo<ProductDetailVo> detail(Integer productId);
}
