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

import java.util.ArrayList;
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

    public InvoiceViewModel findInvoice(int id){
        Invoice invoice = invoiceDao.getInvoice(id);
        return buildInvoiceViewModel(invoice);
    }

    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice){
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setCustomer(customer);
        ivm.setOrderDate(invoice.getOrderDate());
        ivm.setPickUpDate(invoice.getPickUpDate());
        ivm.setReturnDate(invoice.getReturnDate());
        ivm.setLateFee(invoice.getLateFee());
        ivm.setInvoiceItems(invoiceItemList);

        return ivm;
    }

    public List<InvoiceViewModel> findAllInvoices(){
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList){
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }
        return ivmList;
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel){
        Invoice invoice = new Invoice();
        invoice.setId(invoice.getId());
        invoice.setCustomerId(invoice.getCustomerId());
        invoice.setOrderDate(invoice.getOrderDate());
        invoice.setPickUpDate(invoice.getPickUpDate());
        invoice.setReturnDate(invoice.getReturnDate());
        invoice.setLateFee(invoice.getLateFee());

        invoiceDao.updateInvoice(invoice);

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());
        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getId()));

        List<InvoiceItem> invoiceItems = invoiceViewModel.getInvoiceItems();
        invoiceItems.stream()
                .forEach(invoiceItem -> {
                    invoiceItem.setInvoiceId(invoiceViewModel.getId());
                    invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
                });
    }

    public List<InvoiceViewModel> findInvoicesByCustomer(int id){
        List<Invoice> invoiceList = invoiceDao.getInvoiceByCustomer(id);
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList){
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }
        return ivmList;
    }

    @Transactional
    public void removeInvoice(int id){
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemsByInvoice(id);

        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getId()));

        invoiceDao.deleteInvoice(id);
    }

    //=========================================================================
    //Customer Service Layer
    //=========================================================================
    public Customer saveCustomer(Customer customer){
        return customerDao.addCustomer(customer);
    }

    public Customer findCustomer(int id){
        return customerDao.getCustomer(id);
    }

    public List<Customer> findAllCustomers(){
        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer){
        customerDao.updateCustomer(customer);
    }

    public void removeCustomer(int id){
        customerDao.deleteCustomer(id);
    }

    //=========================================================================
    //InvoiceItem Service Layer
    //=========================================================================

    public InvoiceItem saveInvoiceItem(InvoiceItem invoiceItem){
        return invoiceItemDao.addInvoiceItem(invoiceItem);
    }

    public InvoiceItem findInvoiceItem(int id){
        return invoiceItemDao.getInvoiceItem(id);
    }

    public List<InvoiceItem> findAllInvoiceItems(){
        return invoiceItemDao.getAllInvoiceItems();
    }

    public void updateInvoiceItem(InvoiceItem invoiceItem){
        invoiceItemDao.updateInvoiceItem(invoiceItem);
    }

    public void removeInvoiceItem(int id){
        invoiceItemDao.deleteInvoiceItem(id);
    }

    //=========================================================================
    //Item Service Layer
    //=========================================================================

    public Item saveItem(Item item){
        return itemDao.addItem(item);
    }

    public Item findItem(int id){
        return itemDao.getItem(id);
    }

    public List<Item> findAllItems(){
        return itemDao.getAllItems();
    }

    public void updateItem(Item item){
        itemDao.updateItem(item);
    }

    public void removeItem(int id){
        itemDao.deleteItem(id);
    }
}
