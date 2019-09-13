package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

        Item item = new Item();
        item.setName("Random item");
        item.setDescription("Random description");
        item.setDailyRate(09.99);

        item = itemDao.addItem(item);

        Item item1 = itemDao.getItem(item.getId());

    }

    @Test
    public void getItem() {




    }

    @Test
    public void getAllItems() {

        Item item = new Item();
        item.setName("Random item");
        item.setDescription("Random description");
        item.setDailyRate(09.99);

        item = itemDao.addItem(item);

        item = new Item();
        item.setName("Random item 2");
        item.setDescription("Random description 2");
        item.setDailyRate(09.99);

        item = itemDao.addItem(item);

        List<Item> IList = itemDao.getAllItems();
        assertEquals(IList.size(), 2);

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