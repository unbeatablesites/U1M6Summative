package com.company.U1M6Summative.service;

import com.company.U1M6Summative.ViewModel.InvoiceViewModel;
import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ServiceLayer {
    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired
    //constructor
    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao){
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    //=========================================================================
    //Invoice Service Layer
    //=========================================================================
    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){
        return null;
    }

    public InvoiceViewModel findInvoice(InvoiceViewModel invoiceViewModel){
        return null;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){
        return null;
    }

    public List<InvoiceViewModel> findAllInvoices(){
        return null;
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel){

    }

    public List<InvoiceViewModel> findInvoicesByCustomer(int id){
        return null;
    }

    @Transactional
    public void removeInvoice(int id){

    }

    //=========================================================================
    //Customer Service Layer
    //=========================================================================
    public Customer saveCustomer(Customer customer){
        return null;
    }

    public Customer findCustomer(int id){
        return null;
    }

    public List<Customer> findAllCustomers(){
        return null;
    }

    public void updateCustomer(Customer customer){

    }

    public void removeCustomer(int id){

    }

    //=========================================================================
    //InvoiceItem Service Layer
    //=========================================================================

    public InvoiceItem saveInvoiceItem(InvoiceItem invoiceItem){
        return null;
    }

    public InvoiceItem findInvoiceItem(int id){
        return null;
    }

    public List<InvoiceItem> findAllInvoiceItems(){
        return null;
    }

    public void updateInvoiceItem(InvoiceItem invoiceItem){

    }

    public void removeInvoiceItem(int id){

    }

    //=========================================================================
    //Item Service Layer
    //=========================================================================

    public Item saveItem(Item item){
        return null;
    }

    public Item findItem(int id){
        return null;
    }

    public List<Item> findAllItems(){
        return null;
    }

    public void updateItem(Item item){

    }

    public void removeItem(int id){

    }
}
