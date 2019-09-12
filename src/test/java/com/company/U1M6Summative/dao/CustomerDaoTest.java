package com.company.U1M6Summative.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDaoTest {

    @Test
    public void addCustomer() {
    }

    @Test
    public void getCustomer() {
    }

    @Test
    public void getAllCustomers() {
    }

    @Test
    public void udpateCustomer() {
    }package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
//import com.company.U1M6Summative.dao*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class CustomerDaoTest {

    @Autowired
    protected CustomerDao customerDao;

    @Test
    public void addCustomer() {



    }

    @Test
    public void getCustomer() {
    }

    @Test
    public void getAllCustomers() {
    }

    @Test
    public void udpateCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void addGetDeleteCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("wow@now.com");
        customer.setPhone("123-342-3433");
        customer.setCompany("GeorgiaTech");

        customer = customerDao.addCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getId());

        assertEquals(customer, customer2);

        customerDao.deleteCustomer(customer.getId());

        assertNull(customer2);



    }
}
    @Test
    public void deleteCustomer() {
    }
}