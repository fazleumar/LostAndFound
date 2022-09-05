package com.example.demo.dao;

import java.util.List;

import com.example.demo.items.Items;
import com.example.demo.items.ItemsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ItemsDaoImplementation implements ItemsDao {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Items> getAllItems() {
        String query = "SELECT * from items";
        RowMapper<Items> rowMapper = new ItemsRowMapper();
        List<Items> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public Items findItemsById(int id) {
        String query = "SELECT * FROM items WHERE itemID = ?";
        RowMapper<Items> rowMapper = new BeanPropertyRowMapper<Items>(Items.class);
        Items item = jdbcTemplate.queryForObject(query, rowMapper, id);
        return item;
    }

    @Override
    public void addItems(Items item) {
        String query = "INSERT INTO items(reportType, title, description, reportedBy, latitude, longitude, productImage) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, item.getItemID(), item.getReportType(), item.getTitle(), item.getDescription(), item.getReportedBy(), item.getLatitude(), item.getLongitude(), item.getProductImage());
    }

    @Override
    public void updateItems(Items item) {
        String query = "UPDATE items SET reportType-?, title-?, description-?, reportedBy-?, latitude-?, longitude-?, productImage-? WHERE itemID-?";
        jdbcTemplate.update(query, item.getReportType(), item.getTitle(), item.getDescription(), item.getReportedBy(), item.getLatitude(), item.getLongitude(), item.getProductImage());
    }

    @Override
    public void deleteItems(int id) {
        String query = "DELETE FROM items WHERE itemID=?";
        jdbcTemplate.update(query, id);
    }
}