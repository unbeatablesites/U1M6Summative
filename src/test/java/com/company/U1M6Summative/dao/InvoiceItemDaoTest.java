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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;
    @Autowired
    ItemDao itemDao;

    private Item item;
    private Invoice invoice;
    private InvoiceItem invoiceItem;
    private InvoiceItem invoiceItem1;
    private Customer customer;

    @Before
    public void setUp(){
        List<Item> listOfItems = itemDao.getAllItems();
        for(Item item : listOfItems){
            itemDao.deleteItem(item.getId());
        }
        List<Customer> listOfCustomers = customerDao.getAllCustomers();
        for(Customer customer : listOfCustomers){
            customerDao.deleteCustomer(customer.getId());
        }
        List<Invoice> listOfInvoices = invoiceDao.getAllInvoices();
        for(Invoice invoice : listOfInvoices){
            invoiceDao.deleteInvoice(invoice.getId());
        }
        List<InvoiceItem> listOfInvoiceItems = invoiceItemDao.getAllInvoiceItems();
        for( InvoiceItem invoiceItem : listOfInvoiceItems ){
            invoiceItemDao.deleteInvoiceItem(invoiceItem.getId());
        }

        item = new Item();
        item.setName("Item 1");
        item.setDescription("This is an item");
        item.setDailyRate(new BigDecimal("3.95"));

        customer = new Customer();
        customer.setFirstName("Guy");
        customer.setLastName("Guy");
        customer.setCompany("Company");
        customer.setPhone("111-111-1111");
        customer.setEmail("guy@company.com");

        invoice = new Invoice();
        invoice.setCustomerId(customer.getId());
        invoice.setOrderDate(LocalDate.of(2019,05,24));
        invoice.setPickUpDate(LocalDate.of(2019, 05, 25));
        invoice.setReturnDate(LocalDate.of(2019, 05, 28));
        invoice.setLateFee(new BigDecimal("0"));

        invoiceItem = new InvoiceItem();
        invoiceItem.setItemId(item.getId());
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setQuantity(1);
        invoiceItem.setUnitRate(item.getDailyRate());
        invoiceItem.setDiscount(new BigDecimal("0"));

        invoiceItem1 = new InvoiceItem();
        invoiceItem1.setItemId(item.getId());
        invoiceItem1.setInvoiceId(invoice.getId());
        invoiceItem1.setQuantity(13);
        invoiceItem1.setUnitRate(item.getDailyRate());
        invoiceItem1.setDiscount(new BigDecimal(".1"));
    }

    @Test
    public void addInvoiceItem() {
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());
        assertEquals(invoiceItem, invoiceItem1);
    }

    @Test
    public void getInvoiceItem() {
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());
        assertEquals(invoiceItem, invoiceItem1);
    }

    @Test
    public void getAllInvoiceItems() {
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        List<InvoiceItem> listOfInvoiceItems = invoiceItemDao.getAllInvoiceItems();
        assertEquals(1, listOfInvoiceItems.size());
        assertEquals(invoiceItem, listOfInvoiceItems.get(0));
    }

    @Test
    public void updateInvoiceItem() {
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItem.setQuantity(41);
        invoiceItemDao.updateInvoiceItem(invoiceItem);
        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());

        assertEquals(invoiceItem, invoiceItem1);
    }

    @Test
    public void deleteInvoiceItem() {
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItemDao.deleteInvoiceItem(invoiceItem.getId());
        invoiceItem = invoiceItemDao.getInvoiceItem(invoiceItem.getId());
        assertNull(invoiceItem);
    }
}