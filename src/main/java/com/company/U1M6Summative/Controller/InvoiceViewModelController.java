//package com.company.U1M6Summative.Controller;
//
//
//import com.company.U1M6Summative.dto.Invoice;
//import com.company.U1M6Summative.service.ServiceLayer;
//import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/invoice")
//public class InvoiceController {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//
//    @RequestMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Invoice createInvoice(@RequestBody Invoice invoiceViewModel){
//        return serviceLayer.saveInvoice(invoiceViewModel);
//    }
//
//    @RequestMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Invoice> getInvoice(@PathVariable("customerId") int customerId){
//        return serviceLayer.findInvoiceByCustomer(customerId);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public String removeInvoice(@PathVariable int id) {
//        serviceLayer.removeInvoice(id);
//        return "Invoice is deleted";
//    }
//
//}
