package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoJdbcTemplateImpl implements ItemDao{
    private static final String INSERT_ITEM =
        "insert into item(name, description, daily_rate) values (?,?,?)";
    private static final String SELECT_ITEM =
            "select * from item where item_id = ?";
    private static final String SELECT_ALL_ITEMS=
            "select * from item";
    private static final String UPDATE_ITEM=
            "update item set name = ?, description = ?, daily_rate = ? where item_id = ?";
    private static final String DELETE_ITEM=
            "delete from item where item_id = ?";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private Item mapRowToItem(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setDailyRate(rs.getBigDecimal("daily_rate"));
        return item;
    }

    @Override
    @Transactional
    public Item addItem(Item item) {
        jdbcTemplate.update(INSERT_ITEM,
                item.getName(),
                item.getDescription(),
                item.getDailyRate());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        item.setId(id);
        return item;
    }

    @Override
    public Item getItem(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_ITEM, this::mapRowToItem, id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SELECT_ALL_ITEMS, this::mapRowToItem);
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(UPDATE_ITEM,
                item.getName(),
                item.getDescription(),
                item.getDailyRate(), item.getId());
    }

    @Override
    public void deleteItem(int id) {
        jdbcTemplate.update(DELETE_ITEM, id);
    }
}
