package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
//import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private InvoiceDao invoiceDao;

    private Customer customer;
    private Invoice invoice;
    private Invoice invoice1;


    @Before
    public void setUp(){
        List<Invoice> listOfInvoices = invoiceDao.getAllInvoices();
        for( Invoice invoice : listOfInvoices ){
            invoiceDao.deleteInvoice(invoice.getId());
        }

        List<Customer> listOfCustomers = customerDao.getAllCustomers();
        for( Customer customer : listOfCustomers){
            customerDao.deleteCustomer(customer.getId());
        }

        customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("wow@now.com");
        customer.setPhone("123-342-3433");
        customer.setCompany("GeorgiaTech");
        customer = customerDao.addCustomer(customer);

        invoice = new Invoice();
        invoice.setCustomerId(customer.getId());
        invoice.setOrderDate(LocalDate.of(2019,05,24));
        invoice.setPickUpDate(LocalDate.of(2019, 05, 25));
        invoice.setReturnDate(LocalDate.of(2019, 05, 28));
        invoice.setLateFee(new BigDecimal("0").setScale(2, RoundingMode.CEILING));

        invoice1 = new Invoice();
        invoice1.setCustomerId(customer.getId());
        invoice1.setOrderDate(LocalDate.of(2019,06,12));
        invoice1.setPickUpDate(LocalDate.of(2019, 06, 12));
        invoice1.setReturnDate(LocalDate.of(2019, 06, 15));
        invoice1.setLateFee(new BigDecimal("3.5").setScale(2, RoundingMode.CEILING));


    }

    @Test
    public void addInvoice() {
        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.getInvoice(invoice.getId());
        assertEquals(invoice, invoice1);
    }

    @Test
    public void getInvoice() {
        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.getInvoice(invoice.getId());
        assertEquals(invoice, invoice1);
    }

    @Test
    public void getAllInvoices() {
        invoiceDao.addInvoice(invoice);
        List<Invoice> listOfInvoices = invoiceDao.getAllInvoices();
        assertEquals(1, listOfInvoices.size());

    }

    @Test
    public void updateInvoice() {
        invoice = invoiceDao.addInvoice(invoice);
        invoice.setLateFee(new BigDecimal("2.35"));
        invoiceDao.updateInvoice(invoice);
        invoice1 = invoiceDao.getInvoice(invoice.getId());
        assertEquals(invoice, invoice1);
        assertEquals(new BigDecimal("2.35"), invoice1.getLateFee());
    }

    @Test
    public void deleteInvoice() {
        invoice = invoiceDao.addInvoice(invoice);
        invoiceDao.deleteInvoice(invoice.getId());
        invoice = invoiceDao.getInvoice(invoice.getId());
        assertNull(invoice);
    }

    @Test
    public void getInvoiceByCustomer() {
        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.addInvoice(invoice1);

        List<Invoice> listOfInvoices = invoiceDao.getInvoiceByCustomer(customer.getId());
        assertEquals(2, listOfInvoices.size());
    }
}