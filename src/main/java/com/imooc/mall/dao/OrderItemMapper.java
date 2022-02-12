package com.imooc.mall.dao;

import com.imooc.mall.pojo.OrderItem;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
<<<<<<< HEAD
=======

    int batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);

    List<OrderItem> selectByOrderNoSet(@Param("orderNoSet") Set orderNoSet);
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}