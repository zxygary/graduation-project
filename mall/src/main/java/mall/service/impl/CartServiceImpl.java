package mall.service.impl;

import com.google.gson.Gson;
import mall.dao.ProductMapper;
import mall.enums.ProductStatusEnum;
import mall.enums.ResponseEnum;
import mall.form.CartAddForm;
import mall.pojo.Cart;
import mall.pojo.Product;
import mall.service.ICartService;
import mall.vo.CartVo;
import mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    private final static String CART_REDIS_KEY_TEMPLATE = "cart_%d";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    @Override
    public ResponseVo<CartVo> add(Integer uid, CartAddForm form) {
        Integer quantity = 1;

        Product product = productMapper.selectByPrimaryKey(form.getProductId());

        //商品是否存在
        if(product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        //商品是否正常在售
        if(product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }

        //商品库存是否充足
        if (product.getStock() <= 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

        //写入到redis
        //key: cart_1
        redisTemplate.opsForValue().set(String.format(CART_REDIS_KEY_TEMPLATE, uid),
                gson.toJson(new Cart(product.getId(), quantity, form.getSelected())));

        return null;
    }
}
