package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Invoice;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class InvoiceDaoTest {

    @Test
    public void addInvoice() {
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
        invoice.setReturnFee(14.99);
    }

}