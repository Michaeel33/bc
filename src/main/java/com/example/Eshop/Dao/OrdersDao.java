package com.example.Eshop.Dao;

import com.example.Eshop.Dto.Orders;
import java.util.List;

public interface OrdersDao {
    List<Orders> getOrdersForPerId(long perId);
}