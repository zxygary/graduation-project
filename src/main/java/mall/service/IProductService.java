package mall.service;

import mall.vo.ProductVo;
import mall.vo.ResponseVo;

import java.util.List;

/**
 * Created by 廖师兄
 */
public interface IProductService {

	ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
