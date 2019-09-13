package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoTest {

    @Autowired
    CustomerDao trackDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;
    @Autowired
    ItemDao itemDao;


    @Test
    public void addItem() {
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

    @Test
    public void addGetUpdateDeleteItem(){

        Item item = new Item();
        item.setDailyRate();  //big decimal data type format???? wth
        item.setDescription("Movie");
        item.setName("Bad Boys");

    }


}