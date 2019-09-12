package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.dto.Invoice;
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
    public void deleteInvoiceItem() {
    }

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