package mall.service;

import mall.vo.CategoryVo;
import mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

	ResponseVo<List<CategoryVo>> selectAll();

	void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
