package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Before
    public void setUp(){

    }

    @Test
    public void addInvoice() {
        Customer customer = new Customer();
    }

    @Test
    public void getInvoice() {
    }

    @Test
    public void getAllInvoices() {


    }

    @Test
    public void updateInvoice() {


    }

    @Test
    public void deleteInvoice() {
    }

    @Test
    public void getInvoiceByCustomer() {

    }

/*
    public class Invoice {
        private int id;
        private int customerId;
        private LocalDate orderDate;
        private LocalDate pickUpDate;
        private LocalDate returnDate;
        private BigDecimal returnFee;

 */
    @Test
    public void addGetDeleteInvoice(){
        Invoice invoice = new Invoice();
        //invoice.getCustomerId();
        invoice.setOrderDate().parse("2018-11-43");
        invoice.setPickUpDate();
        invoice.setReturnDate();
        invoice.setLateFee(14.99);

    }

}