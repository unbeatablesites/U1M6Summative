package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Test;

import org.junit.runner.RunWith;
import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class ItemDaoTest {

    @Autowired
    ItemDao itemDao;


    @Test
    public void addItem() {
        Item item = new Item();
        item.setId(01);
        item.setName("Movie10");
        item.setDescription("Running");
        item.setDailyRate(new BigDecimal("11.42"));

    }

    @Test
    public void getItem() {
    }

    @Test
    public void getAllItems() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void deleteItem() {

    }

//    @Test
//    public void addGetDeleteCustomer(){
//
//        Customer customer = new Customer();
//        customer.setFirstName("John");
//        customer.setLastName("Doe");
//        customer.setEmail("wow@now.com");
//        customer.setPhone("123-342-3433");
//        customer.setCompany("GeorgiaTech");
//
//        customer = customerDao.addCustomer(customer);//adds customer to database
//
//        Customer customer2 = customerDao.getCustomer(customer.getId());//get customer from DB and set customer2 equal to it.
//
//        assertEquals(customer, customer2); //test that the created customer and the retrieved customer object are the same.
//
//        customerDao.deleteCustomer(customer.getId()); //delete customer object
//
//        assertNull(customer2);//test that customer2 is now null since customer was deleted.
//
//    }
//}

    @Test
    public void addGetUpdateDeleteItem(){

        Item item = new Item();
        item.setId(04);
        item.setName("Movie1");
        item.setDescription("DVD");
        item.setDailyRate(new BigDecimal("33.22"));

        item = itemDao.addItem(item);
        Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, item2);
        itemDao.deleteItem(item.getId());
        assertNull(item2);



    }


}