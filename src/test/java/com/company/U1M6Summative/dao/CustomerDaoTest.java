
package com.company.U1M6Summative.dao;

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

        Customer customer = new Customer();
        customer.setFirstName("Bart");
        customer.setLastName("Simpson");
        customer.setEmail("all@redbox1.com");
        customer.setPhone("444-555-3233");
        customer.setCompany("Hawaii");

        customer = customerDao.addCustomer(customer);//adds customer to database

        Customer customer2 = customerDao.getCustomer(customer.getId());//get customer from DB and set customer2 equal to it.

        assertEquals(customer, customer2); //test that the created customer and the retrieved customer object are the same.

    }

    @Test
    public void getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Bart");
        customer.setLastName("Simpson");
        customer.setEmail("all@redbox1.com");
        customer.setPhone("444-555-3233");
        customer.setCompany("Hawaii");

        customer = customerDao.addCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getId());//get customer from DB and set customer2 equal to it.

        assertEquals(customer, customer2); //test that the created customer and the retrieved customer object are the same.

    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Bart");
        customer.setLastName("Simpson");
        customer.setEmail("all@redbox1.com");
        customer.setPhone("444-555-3233");
        customer.setCompany("Hawaii");

        customerDao.addCustomer(customer);//adds customer to database

        Customer customer2 = new Customer();
        customer2.setFirstName("Bart");
        customer2.setLastName("Simpson");
        customer2.setEmail("all@redbox1.com");
        customer2.setPhone("444-555-3233");
        customer2.setCompany("Hawaii");

        customerDao.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Bart");
        customer3.setLastName("Simpson");
        customer3.setEmail("all@redbox1.com");
        customer3.setPhone("444-555-3233");
        customer3.setCompany("Hawaii");

        customerDao.addCustomer(customer3);

        //Gets all customers, and adds them to a list
        List<Customer> customerList = customerDao.getAllCustomers();

        // Checks equality
        assertEquals(3, customerList.size());

    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();//create customer
        customer.setId(customer.getId());
        customer.setFirstName("Jack");
        customer.setLastName("Donnie");
        customer.setEmail("ohh@kay.com");
        customer.setPhone("999-333-4444");
        customer.setCompany("Mars");
        customer = customerDao.addCustomer(customer); //add customer to db via the dao

        customer.setFirstName("UPDATED"); //set new customer first name
        customer.setLastName("UPDATED");//set new customer last name
        customerDao.updateCustomer(customer);//send customer update to db via dao

        //CustomerDao.updateCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getId());

        assertEquals(customer, customer2);
    }

    @Test
    public void deleteCustomerTest() {
        Customer customer = new Customer();
        customer.setFirstName("Hope");
        customer.setLastName("Lost");
        customer.setEmail("lorem@ipsum.com");
        customer.setPhone("123-342-3433");
        customer.setCompany("Georgia");

        customer = customerDao.addCustomer(customer); //add customer to DB
        customerDao.deleteCustomer(customer.getId());//delete customer2 from db
        assertNull(customerDao.getCustomer(customer.getId()));//test that customer2 is deleted and now null

    }

    /*@Test
    public void addGetDeleteCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("wow@now.com");
        customer.setPhone("123-342-3433");
        customer.setCompany("GeorgiaTech");

        customer = customerDao.addCustomer(customer);//adds customer to database

        Customer customer2 = customerDao.getCustomer(customer.getId());//get customer from DB and set customer2 equal to it.

        assertEquals(customer, customer2); //test that the created customer and the retrieved customer object are the same.

        customerDao.deleteCustomer(customer.getId()); //delete customer object

        assertNull(customer2);//test that customer2 is now null since customer was deleted.

    }*/
}