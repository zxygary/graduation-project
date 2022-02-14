package mall.service;

import mall.form.CartAddForm;
import mall.vo.CartVo;
import mall.vo.ResponseVo;

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);
}
