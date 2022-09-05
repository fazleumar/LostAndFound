package com.example.demo.items;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ItemsRowMapper implements RowMapper<Items>  {

    @Override
    public Items mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Items item = new Items();
        item.setItemID(resultSet.getInt("itemID"));
        item.setReportType(resultSet.getString("reportType"));
        item.setTitle(resultSet.getString("title"));
        item.setDescription(resultSet.getString("description"));
        item.setReportedBy(resultSet.getString("reportedBy"));
        item.setLatitude(resultSet.getDouble("latitude"));
        item.setLongitude(resultSet.getDouble("longitude"));
        item.setProductImage(resultSet.getString("productImage"));

        return item;
    }
}