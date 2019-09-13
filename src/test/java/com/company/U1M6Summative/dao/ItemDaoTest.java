package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import org.junit.runner.RunWith;
import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


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

//        Item item = new Item();
//        item.setName("Random item");
//        item.setDescription("Random description");
//        item.setDailyRate(09.99);
//
//        item = itemDao.addItem(item);
//
//        Item item1 = itemDao.getItem(item.getId());

    }

    @Test
    public void getItem() {



    }

    @Test
    public void getAllItems() {

        Item item = new Item();
        item.setName("Random item");
        item.setDescription("Random description");
        item.setDailyRate(new BigDecimal(2.99));

        item = itemDao.addItem(item);

        item = new Item();
        item.setName("Random item 2");
        item.setDescription("Random description 2");
        item.setDailyRate(new BigDecimal(4.99));

        item = itemDao.addItem(item);

        List<Item> IList = itemDao.getAllItems();
        assertEquals(IList.size(), 2);

    }

//    @Test
//    public void updateCustomer() {
//        Customer customer = new Customer();//create customer
//        customer.setId(customer.getId());
//        customer.setFirstName("Jack");
//        customer.setLastName("Donnie");
//        customer.setEmail("ohh@kay.com");
//        customer.setPhone("999-333-4444");
//        customer.setCompany("Mars");
//        customer = customerDao.addCustomer(customer); //add customer to db via the dao
//
//        customer.setFirstName("UPDATED"); //set new customer first name
//        customer.setLastName("UPDATED");//set new customer last name
//        customerDao.updateCustomer(customer);//send customer update to db via dao
//
//        //CustomerDao.updateCustomer(customer);
//
//        Customer customer2 = customerDao.getCustomer(customer.getId());
//
//        assertEquals(customer, customer2);
//    }
    @Test
    public void updateItem() {
        Item item = new Item();
        item.setName("DVD");
        item.setDescription("Shuttle Launch");
        item.setDailyRate(new BigDecimal(10.99));
        item = itemDao.addItem(item);

        item.setName("UPDATE");
        item.setDescription("UPDATE");
        itemDao.updateItem(item);
        //Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, itemDao.getItem(item.getId()));
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

//        Item item = new Item();
//        item.setDailyRate();  //big decimal data type format???? wth
//        item.setDescription("Movie");
//        item.setName("Bad Boys");

    }


}