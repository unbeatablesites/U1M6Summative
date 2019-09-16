package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao{
    private static final String INSERT_INVOICE_ITEM=
            "insert into invoice_item(invoice_id, item_id, quantity, unit_rate, discount) values (?,?,?,?,?)";
    private static final String SELECT_INVOICE_ITEM=
            "select * from invoice_item where invoice_item_id = ?";
    private static final String SELECT_ALL_INVOICE_ITEMS=
            "select * from invoice_item";
    private static final String UPDATE_INVOICE_ITEM=
            "update invoice_item set invoice_id = ?, item_id = ?, quantity = ?, unit_rate = ?, discount = ? " +
                    "where invoice_item_id = ?";
    private static final String DELETE_INVOICE_ITEM=
            "delete from invoice_item where invoice_item_id = ?";
    private static final String SELECT_INVOICE_ITEMS_BY_INVOICEID=
            "select * from invoice_item where invoice_id = ?";

    @Override
    public List<InvoiceItem> getInvoiceItemsByInvoice(int id) {
        return jdbcTemplate.query(SELECT_INVOICE_ITEMS_BY_INVOICEID, this::mapRowToInvoiceItem, id);
    }

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private InvoiceItem mapRowToInvoiceItem(ResultSet rs, int rowNum) throws SQLException{
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(rs.getInt("invoice_item_id"));
        invoiceItem.setInvoiceId(rs.getInt("invoice_id"));
        invoiceItem.setItemId(rs.getInt("item_id"));
        invoiceItem.setQuantity(rs.getInt("quantity"));
        invoiceItem.setUnitRate(rs.getBigDecimal("unit_rate"));
        invoiceItem.setDiscount(rs.getBigDecimal("discount"));
        return invoiceItem;
    }
    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(INSERT_INVOICE_ITEM,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        invoiceItem.setId(id);
        return invoiceItem;
    }

    @Override
    public InvoiceItem getInvoiceItem(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_INVOICE_ITEM, this::mapRowToInvoiceItem, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_ITEMS, this::mapRowToInvoiceItem);
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(UPDATE_INVOICE_ITEM,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount(), invoiceItem.getId());
    }

    @Override
    public void deleteInvoiceItem(int id) {
        jdbcTemplate.update(DELETE_INVOICE_ITEM, id);
    }
}
