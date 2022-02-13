package mall.service;

import mall.vo.CategoryVo;
import mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * Created by 廖师兄
 */
public interface ICategoryService {

	ResponseVo<List<CategoryVo>> selectAll();

	void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
