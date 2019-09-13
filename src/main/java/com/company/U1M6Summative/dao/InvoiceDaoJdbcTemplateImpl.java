package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao{
    private static final String INSERT_INVOICE_SQL =
        "INSERT INTO invoice (customer_id, order_date, pickup_date, return_date, late_fee) VALUES(?, ?, ?, ?, ?)";

    private static final String SELECT_INVOICE_SQL =
        "SELECT * FROM invoice WHERE invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL =
        "SELECT * FROM invoice";

    private static final String UPDATE_INVOICE_SQL =
        "UPDATE invoice SET order_date = ?, pickup_date = ?, return_date = ?, late_fee = ? WHERE invoice_id = ?";

    private static final String DELETE_INVOICE_SQL =
            "DELETE FROM invoice WHERE invoice_id = ?";

    private static final String SELECT_INVOICES_BY_CUSTOMER =
            "SELECT * FROM invoice WHERE customer_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL, invoice.getCustomerId(), invoice.getOrderDate(), invoice.getPickUpDate(),
                invoice.getReturnDate(), invoice.getLateFee());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        invoice.setId(id);
        return invoice;
    }

    @Override
    public Invoice getInvoice(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL, invoice.getOrderDate(), invoice.getPickUpDate(),
                invoice.getReturnDate(), invoice.getLateFee(), invoice.getId());
    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    @Override
    public List<Invoice> getInvoiceByCustomer(int customerId) {
        return jdbcTemplate.query(SELECT_INVOICES_BY_CUSTOMER, this::mapRowToInvoice, customerId);
    }

    public Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date").toLocalDate());
        invoice.setPickUpDate(rs.getDate("pickup_date").toLocalDate());
        invoice.setReturnDate(rs.getDate("return_date").toLocalDate());
        invoice.setLateFee(rs.getBigDecimal("late_fee"));

        return invoice;
    }
}
