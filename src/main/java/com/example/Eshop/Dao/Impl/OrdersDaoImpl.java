package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.OrdersDao;
import com.example.Eshop.Dto.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Orders> getOrdersForPerId(long perId) {
        String sql = "SELECT orderNumber, price FROM `orders` WHERE perId = ?";
        return jdbcTemplate.query(sql, this::mapOrdersForPerId, perId);
    }

    private List<Orders> mapOrdersForPerId(ResultSet rs) throws SQLException {
        List<Orders> ordersList = new ArrayList<>();
        while (rs.next()) {
            Orders orders = new Orders();
            orders.setOrderNumber(rs.getString("orderNumber"));
            orders.setPrice(rs.getDouble("price"));
            ordersList.add(orders);
        }
        return ordersList;
    }
}
