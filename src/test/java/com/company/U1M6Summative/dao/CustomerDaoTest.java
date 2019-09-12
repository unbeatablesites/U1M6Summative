//package com.company.U1M6Summative.dao;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class CustomerDaoTest {
//
//    @Test
//    public void addCustomer() {
//    }
//
//    @Test
//    public void getCustomer() {
//    }
//
//    @Test
//    public void getAllCustomers() {
//    }
//
//    @Test
//    public void updateCustomer() {
//    }
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

        customer = customerDao.addCustomer(customer);//adds customer to database

        Customer customer2 = new Customer();
        customer2.setFirstName("Test2");
        customer2.setLastName("Test3Last3");
        customer2.setEmail("2test@redbox1.com");
        customer2.setPhone("444-555-3233");
        customer2.setCompany("Hawaii");

        customer = customerDao.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Test3");
        customer3.setLastName("Test3Last3");
        customer3.setEmail("3test@redbox1.com");
        customer3.setPhone("444-555-3233");
        customer3.setCompany("Hawaii");

        customer2 = customerDao.getCustomer(customer.getId());//get customer from DB and set customer2 equal to it.

        assertEquals(customer, customer2); //test that the created customer and the retrieved customer object are the same.



    }

    @Test
    public void getAllCustomers() {
    }

    /*
    @Test
    public void updateCoffee() {

        Roaster roaster = new Roaster();
        roaster.setName("PERC");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostal_code("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("totallyrealemail@perc.com");
        roaster.setNote("Delicious coffee.");

        RoasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Juggernaut");
        coffee.setCount(73);
        coffee.setUnit_price(12.99);
        coffee.setDescription("Bold and full flavored, this coffee will start your day right.");
        coffee.setType("Espresso");

        coffee = CoffeeDao.addCoffee(coffee);

        coffee.setName("UPDATED");
        coffee.setCount(65);
        coffee.setUnit_price(13.29);

        CoffeeDao.updateCoffee(coffee);

        Coffee coffee2 = CoffeeDao.getCoffee(coffee.getCoffee_id());

        assertEquals(coffee2, coffee);
    }

     */
    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setId(customer.getId());
        customer.setFirstName("Jack");
        customer.setLastName("Donnie");
        customer.setEmail("ohh@kay.com");
        customer.setPhone("999-333-4444");
        customer.setCompany("Mars");
        customer = customerDao.addCustomer(customer);

        customer.setFirstName("UPDATED");
        customer.setLastName("UPDATED");
        customerDao.updateCustomer(customer);

        //CustomerDao.updateCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getId());

        assertEquals(customer2, customer);
    }


    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Hope");
        customer.setLastName("Lost");
        customer.setEmail("lorem@ipsum.com");
        customer.setPhone("123-342-3433");
        customer.setCompany("Georgia");

        customerDao.deleteCustomer(customer.getId());
        assertNull(customer);

    }

    @Test
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



    }
}