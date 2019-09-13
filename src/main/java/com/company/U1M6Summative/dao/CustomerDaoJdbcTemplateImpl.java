package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao {

    private static final String INSERT_CUSTOMER_SQL =
            "INSERT INTO customer (first_name, last_name, email, company, phone) VALUES(?, ?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER_SQL =
            "SELECT * FROM customer WHERE customer_id = ?";

    private static final String SELECT_ALL_CUSTOMERS_SQL =
            "SELECT * FROM customer";

    private static final String UPDATE_CUSTOMER_SQL =
            "UPDATE customer SET first_name = ?, last_name = ?, email = ?, company = ?, phone = ? WHERE customer_id = ?";

    private static final String DELETE_CUSTOMER_SQL =
            "DELETE FROM customer WHERE customer_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER_SQL, customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getCompany(), customer.getPhone());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        customer.setId(id);
        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_SQL, this::mapRowToCustomer, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(SELECT_ALL_CUSTOMERS_SQL, this::mapRowToCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_CUSTOMER_SQL, customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getCompany(), customer.getPhone(), customer.getId());
    }

    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_CUSTOMER_SQL, id);
    }

    public Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setCompany(rs.getString("company"));
        customer.setPhone(rs.getString("phone"));

        return customer;
    }
}
