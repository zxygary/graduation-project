package com.imooc.mall.dao;

import com.imooc.mall.pojo.Order;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
<<<<<<< HEAD
=======

    List<Order> selectByUid(Integer uid);

    Order selectByOrderNo(Long orderNo);
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}