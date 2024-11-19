package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.ItemsDao;
import com.example.Eshop.Dto.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemsDaoImpl implements ItemsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Items> getItemsForOrder(String orderNo) {
        String sql = "SELECT i.druhTovaru, i.cena, p.productType " +
                "FROM itemsfororder ifo " +
                "JOIN items i ON ifo.itemId = i.itemId " +
                "JOIN products p ON i.prodId = p.prodId " +
                "WHERE ifo.orderNumber = ?";
        return jdbcTemplate.query(sql, this::mapItemsForOrder, orderNo);
    }

    private List<Items> mapItemsForOrder(ResultSet rs) throws SQLException {
        List<Items> itemsList = new ArrayList<>();
        while (rs.next()) {
            Items item = new Items();
            item.setKategoria(rs.getString("productType"));
            item.setDruhTovaru(rs.getString("druhTovaru"));
            item.setCena(rs.getDouble("cena"));
            itemsList.add(item);
        }
        return itemsList;
    }
}