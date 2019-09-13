package com.company.U1M6Summative.Controller;


import com.company.U1M6Summative.ViewModel.InvoiceViewModel;
import com.company.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceViewModelController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoiceViewModel){
        return serviceLayer.saveInvoice(invoiceViewModel);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getInvoice(@PathVariable("customerId") int customerId){
        return serviceLayer.findInvoicesByCustomer(customerId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String removeInvoice(@PathVariable int id) {
        serviceLayer.removeInvoice(id);
        return "Invoice is deleted";
    }

}
