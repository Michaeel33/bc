package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dto.Items;
import java.util.List;

public interface ItemsDao {
    List<Items> getItemsForOrder(String orderNo);
}
