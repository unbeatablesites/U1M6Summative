package com.company.U1M6Summative.dao;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.junit.Before;
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
    CustomerDao customerDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp(){
        List<InvoiceItem> listOfInvoiceItems = invoiceItemDao.getAllInvoiceItems();
        for( InvoiceItem invoiceItem : listOfInvoiceItems ){
            invoiceItemDao.deleteInvoiceItem(invoiceItem.getId());
        }
        List<Invoice> listOfInvoices = invoiceDao.getAllInvoices();
        for(Invoice invoice : listOfInvoices){
            invoiceDao.deleteInvoice(invoice.getId());
        }
        List<Item> listOfItems = itemDao.getAllItems();
        for(Item item : listOfItems){
            itemDao.deleteItem(item.getId());
        }
        List<Customer> listOfCustomers = customerDao.getAllCustomers();
        for(Customer customer : listOfCustomers){
            customerDao.deleteCustomer(customer.getId());
        }
    }

    @Test
    public void addItem() {
        Item item = new Item();
        item.setId(01);
        item.setName("Movie10");
        item.setDescription("Running");
        item.setDailyRate(new BigDecimal("11.42"));

        item = itemDao.addItem(item);
        //Item item2 = itemDao.getItem(item.getId());
        assertEquals(item,itemDao.getItem(item.getId()));

    }

    @Test
    public void getItem() {
        Item item = new Item();
        item.setId(01);
        item.setName("DVDR");
        item.setDescription("Walking");
        item.setDailyRate(new BigDecimal("12.99"));

        item = itemDao.addItem(item);
        Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, item2);
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

    @Test
    public void updateItem() {
        Item item = new Item();
        item.setName("DVD");
        item.setDescription("Shuttle Launch");
        item.setDailyRate(new BigDecimal("10.99"));
        item = itemDao.addItem(item);

        item.setName("UPDATE");
        item.setDescription("UPDATE");
        itemDao.updateItem(item);
        //Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, itemDao.getItem(item.getId()));
    }

    @Test
    public void deleteItem() {

        Item item = new Item();
        item.setId(04);
        item.setName("Movie1");
        item.setDescription("DVD");
        item.setDailyRate(new BigDecimal("33.22"));

        item = itemDao.addItem(item);
        Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, item2);
        itemDao.deleteItem(item.getId());
        item2 = itemDao.getItem(item2.getId());
        assertNull(item2);
    }

    @Test
    public void addGetUpdateDeleteItem() {

        Item item = new Item();
        item.setId(04);
        item.setName("Movie1");
        item.setDescription("DVD");
        item.setDailyRate(new BigDecimal("33.22"));

        item = itemDao.addItem(item);
        Item item2 = itemDao.getItem(item.getId());
        assertEquals(item, item2);
        itemDao.deleteItem(item.getId());
        item2 = itemDao.getItem(item.getId());
        assertNull(item2);


    }
}