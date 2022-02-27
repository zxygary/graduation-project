package mall.service;

import com.mall.MallApplicationTests;
import mall.enums.ResponseEnum;
import mall.vo.ProductVo;
import mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 廖师兄
 */
public class IProductServiceTest extends MallApplicationTests {

	@Autowired
	private IProductService productService;

	@Test
	public void list() {
		ResponseVo<List<ProductVo>> responseVo = productService.list(null, 1, 1);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}