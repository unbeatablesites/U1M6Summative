package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {
    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private ItemDao itemDao;
    private InvoiceItemDao invoiceItemDao;
    private ServiceLayer serviceLayer;

    //=========================================================================
    //Mock Setups
    //=========================================================================

    private void setupInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setCustomerId(1);
        invoice.setOrderDate(LocalDate.of(2019, 01, 01));
        invoice.setPickUpDate(LocalDate.of(2019, 01,07));
        invoice.setReturnDate(LocalDate.of(2019, 01, 15));
        invoice.setLateFee(new BigDecimal("8.00"));

        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(1);
        invoice1.setOrderDate(LocalDate.of(2019, 01, 01));
        invoice1.setPickUpDate(LocalDate.of(2019, 01,07));
        invoice1.setReturnDate(LocalDate.of(2019, 01, 15));
        invoice1.setLateFee(new BigDecimal("8.00"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);
        
        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
        doReturn(invoiceList).when(invoiceDao).getInvoiceByCustomer(1);
    }

    private void setupCustomerDaoMock(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");

        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("johndoe@gmail.com");
        customer1.setCompany("Cognizant");
        customer1.setPhone("1112221234");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer1);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(customerList).when(customerDao).getAllCustomers();
    }

    private void setupItemDaoMock(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
        Item item = new Item();
        item.setId(1);
        item.setName("Hot Air Balloon");
        item.setDailyRate(new BigDecimal("200.00"));
        item.setDescription("Blue");

        Item item1 = new Item();
        item1.setName("Hot Air Balloon");
        item1.setDailyRate(new BigDecimal("200.00"));
        item1.setDescription("Blue");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);

        doReturn(item).when(itemDao).addItem(item1);
        doReturn(item).when(itemDao).getItem(1);
        doReturn(itemList).when(itemDao).getAllItems();
    }

    private void setupInvoiceItemDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(1);
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        InvoiceItem invoiceItem1 = new InvoiceItem();
        invoiceItem1.setInvoiceId(1);
        invoiceItem1.setQuantity(2);
        invoiceItem1.setUnitRate(new BigDecimal("250.00"));
        invoiceItem1.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        doReturn(invoiceItem).when(invoiceItemDao).addInvoiceItem(invoiceItem1);
        doReturn(invoiceItem).when(invoiceItemDao).getInvoiceItem(1);
        doReturn(invoiceItemList).when(invoiceItemDao).getAllInvoiceItems();
    }

    //=========================================================================
    //Invoice Service Layer
    //=========================================================================

    @Test
    public void saveInvoice() {
    }

    @Test
    public void findInvoice() {
    }

    @Test
    public void findAllInvoices() {
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void findInvoicesByCustomer() {
    }

    @Test
    public void removeInvoice() {
    }

    //=========================================================================
    //Customer Service Layer
    //=========================================================================

    @Test
    public void saveCustomer() {
    }

    @Test
    public void findCustomer() {
    }

    @Test
    public void findAllCustomers() {
    }

    @Test
    public void udpateCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }

    //=========================================================================
    //InvoiceItem Service Layer
    //=========================================================================

    @Test
    public void saveInvoiceItem() {
    }

    @Test
    public void findInvoiceItem() {
    }

    @Test
    public void findAllInvoiceItems() {
    }

    @Test
    public void updateInvoiceItem() {
    }

    @Test
    public void removeInvoiceItem() {
    }

    //=========================================================================
    //Item Service Layer
    //=========================================================================


    @Test
    public void saveItem() {
    }

    @Test
    public void findItem() {
    }

    @Test
    public void findAllItems() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void deleteItem() {
    }
}