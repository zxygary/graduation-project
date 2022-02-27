package com.service;

import com.imooc.mall.MallApplicationTests;
import mall.form.CartAddForm;
import mall.service.ICartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ICartServiceTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(26);
        form.setSelected(true);
        cartService.add(1, form);
    }
}