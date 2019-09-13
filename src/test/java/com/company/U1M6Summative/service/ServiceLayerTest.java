package com.company.U1M6Summative.service;

import com.company.U1M6Summative.ViewModel.InvoiceViewModel;
import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

    @Before
    public void setUp() throws Exception{
        setupInvoiceDaoMock();
        setupInvoiceItemDaoMock();
        setupItemDaoMock();
        setupCustomerDaoMock();

        serviceLayer = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);
    }

    //=========================================================================
    //Invoice Service Layer
    //=========================================================================

    @Test
    public void saveInvoice() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ivm.setInvoiceItems(invoiceItemList);

        ivm = serviceLayer.saveInvoice(ivm);

        InvoiceViewModel fromService = serviceLayer.findInvoice(ivm.getId());
        assertEquals(ivm, fromService);
    }

    @Test
    public void findInvoice() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ivm.setInvoiceItems(invoiceItemList);

        ivm = serviceLayer.saveInvoice(ivm);

        InvoiceViewModel fromService = serviceLayer.findInvoice(ivm.getId());
        assertEquals(ivm, fromService);
    }

    @Test
    public void findAllInvoices() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ivm.setInvoiceItems(invoiceItemList);

        ivm = serviceLayer.saveInvoice(ivm);

        List<InvoiceViewModel> imvList = serviceLayer.findAllInvoices();
        assertEquals(1, imvList.size());
        assertEquals(ivm, imvList.get(0));
    }

    @Test
    public void updateInvoice() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setId(1);

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);

        doNothing().when(invoiceDao).updateInvoice(invoiceCaptor.capture());

        serviceLayer.updateInvoice(ivm);
        verify(invoiceDao, times(1)).updateInvoice(invoiceCaptor.getValue());

        Invoice invoice = invoiceCaptor.getValue();
        assertEquals(ivm.getId(), invoice.getId());
        assertEquals(ivm.getCustomer().getId(), invoice.getCustomerId());
        assertEquals(ivm.getOrderDate(), invoice.getOrderDate());
        assertEquals(ivm.getPickUpDate(), invoice.getPickUpDate());
        assertEquals(ivm.getReturnDate(), invoice.getReturnDate());
        assertEquals(ivm.getLateFee(), invoice.getLateFee());
    }

    @Test
    public void findInvoicesByCustomer() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ivm.setInvoiceItems(invoiceItemList);

        ivm = serviceLayer.saveInvoice(ivm);

        List<InvoiceViewModel> imvList = serviceLayer.findInvoicesByCustomer(ivm.getCustomer().getId());
        assertEquals(1, imvList.size());
        assertEquals(ivm, imvList.get(0));
    }

    @Test
    public void removeInvoice() {
        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setId(1);

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);
        ivm.setOrderDate(LocalDate.of(2019, 01, 01));
        ivm.setPickUpDate(LocalDate.of(2019, 01,07));
        ivm.setReturnDate(LocalDate.of(2019, 01, 15));
        ivm.setLateFee(new BigDecimal("8.00"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(invoiceDao).deleteInvoice(idCaptor.capture());
        serviceLayer.removeInvoice(ivm.getId());
        verify(invoiceDao, times(1)).deleteInvoice(idCaptor.getValue());

        assertEquals(1, idCaptor.getValue().intValue());
    }

    //=========================================================================
    //Customer Service Layer
    //=========================================================================

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");

        customer = serviceLayer.saveCustomer(customer);
        Customer fromService = serviceLayer.findCustomer(customer.getId());
        assertEquals(customer, fromService);
    }

    @Test
    public void findCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");

        customer = serviceLayer.saveCustomer(customer);
        Customer fromService = serviceLayer.findCustomer(customer.getId());
        assertEquals(customer, fromService);
    }

    @Test
    public void findAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");

        customer = serviceLayer.saveCustomer(customer);

        List<Customer> customerList = serviceLayer.findAllCustomers();
        assertEquals(1, customerList.size());
        assertEquals(customer, customerList.get(0));
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("1112221234");

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);

        doNothing().when(customerDao).updateCustomer(customerCaptor.capture());
        serviceLayer.updateCustomer(customer);
        verify(customerDao, times(1)).updateCustomer(customerCaptor.getValue());

        Customer customer1 = customerCaptor.getValue();
        assertEquals(customer.getId(), customer1.getId());
        assertEquals(customer.getFirstName(), customer1.getFirstName());
        assertEquals(customer.getLastName(), customer1.getLastName());
        assertEquals(customer.getEmail(), customer1.getEmail());
        assertEquals(customer.getCompany(), customer1.getCompany());
        assertEquals(customer.getPhone(), customer1.getPhone());
    }

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setId(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(customerDao).deleteCustomer(idCaptor.capture());
        serviceLayer.removeCustomer(1);

        verify(customerDao, times(1)).deleteCustomer(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    //=========================================================================
    //InvoiceItem Service Layer
    //=========================================================================

    @Test
    public void saveInvoiceItem() {
        InvoiceItem invoiceItem =  new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        invoiceItem = serviceLayer.saveInvoiceItem(invoiceItem);
        InvoiceItem fromService = serviceLayer.findInvoiceItem(invoiceItem.getId());
        assertEquals(invoiceItem, fromService);
    }

    @Test
    public void findInvoiceItem() {
        InvoiceItem invoiceItem =  new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        invoiceItem = serviceLayer.saveInvoiceItem(invoiceItem);
        InvoiceItem fromService = serviceLayer.findInvoiceItem(invoiceItem.getId());
        assertEquals(invoiceItem, fromService);
    }

    @Test
    public void findAllInvoiceItems() {
        InvoiceItem invoiceItem =  new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        invoiceItem = serviceLayer.saveInvoiceItem(invoiceItem);

        List<InvoiceItem> invoiceItemList = serviceLayer.findAllInvoiceItems();
        assertEquals(1, invoiceItemList.size());
        assertEquals(invoiceItem, invoiceItemList.get(0));
    }

    @Test
    public void updateInvoiceItem() {
        InvoiceItem invoiceItem =  new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setInvoiceId(1);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("250.00"));
        invoiceItem.setDiscount(new BigDecimal("20.00"));

        ArgumentCaptor<InvoiceItem> invoiceItemCaptor = ArgumentCaptor.forClass(InvoiceItem.class);

        doNothing().when(invoiceItemDao).updateInvoiceItem(invoiceItemCaptor.capture());
        serviceLayer.updateInvoiceItem(invoiceItem);
        verify(invoiceItemDao, times(1)).updateInvoiceItem(invoiceItemCaptor.getValue());

        InvoiceItem invoiceItem1 = invoiceItemCaptor.getValue();
        assertEquals(invoiceItem.getId(), invoiceItem1.getId());
        assertEquals(invoiceItem.getInvoiceId(), invoiceItem1.getInvoiceId());
        assertEquals(invoiceItem.getQuantity(), invoiceItem1.getQuantity());
        assertEquals(invoiceItem.getUnitRate(), invoiceItem1.getUnitRate());
        assertEquals(invoiceItem.getDiscount(), invoiceItem1.getDiscount());
    }

    @Test
    public void removeInvoiceItem() {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(invoiceItemDao).deleteInvoiceItem(idCaptor.capture());
        serviceLayer.removeInvoiceItem(invoiceItem.getId());

        verify(invoiceDao, times(1)).deleteInvoice(idCaptor.getValue());

        assertEquals(1, idCaptor.getValue().intValue());
    }

    //=========================================================================
    //Item Service Layer
    //=========================================================================


    @Test
    public void saveItem() {
        Item item = new Item();
        item.setName("Hot Air Balloon");
        item.setDailyRate(new BigDecimal("200.00"));
        item.setDescription("Blue");

        item = serviceLayer.saveItem(item);
        Item fromService = serviceLayer.findItem(item.getId());
        assertEquals(item, fromService);
    }

    @Test
    public void findItem() {
        Item item = new Item();
        item.setName("Hot Air Balloon");
        item.setDailyRate(new BigDecimal("200.00"));
        item.setDescription("Blue");

        item = serviceLayer.saveItem(item);
        Item fromService = serviceLayer.findItem(item.getId());
        assertEquals(item, fromService);
    }

    @Test
    public void findAllItems() {
        Item item = new Item();
        item.setName("Hot Air Balloon");
        item.setDailyRate(new BigDecimal("200.00"));
        item.setDescription("Blue");

        item = serviceLayer.saveItem(item);

        List<Item> itemList = serviceLayer.findAllItems();
        assertEquals(1, itemList.size());
        assertEquals(item, itemList.get(0));
    }

    @Test
    public void updateItem() {
        Item item = new Item();
        item.setId(1);
        item.setName("Hot Air Balloon");
        item.setDailyRate(new BigDecimal("200.00"));
        item.setDescription("Blue");

        ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

        doNothing().when(itemDao).updateItem(itemCaptor.capture());
        serviceLayer.updateItem(item);
        verify(itemDao, times(1)).updateItem(itemCaptor.getValue());

        Item item1 = itemCaptor.getValue();
        assertEquals(item.getId(), item1.getId());
        assertEquals(item.getName(), item1.getName());
        assertEquals(item.getDailyRate(), item1.getDailyRate());
        assertEquals(item.getDescription(), item1.getDescription());
    }

    @Test
    public void deleteItem() {
        Item item = new Item();
        item.setId(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(itemDao).deleteItem(idCaptor.capture());
        serviceLayer.removeItem(1);

        verify(itemDao, times(1)).deleteItem(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }
}