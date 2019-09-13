<<<<<<< HEAD
package com.company.U1M6Summative.Controller;

import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/iteminvoice")
public class InvoiceItemController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceItem createInvoice(@RequestBody @Valid InvoiceItem invoiceItem){
        return serviceLayer.saveInvoiceItem(invoiceItem);
    }

    @RequestMapping(value = "/{invoice_item_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public InvoiceItem getInvoiceItem(@PathVariable("invoice_item_id") int invoiceItemId){
        return serviceLayer.findInvoiceItem(invoiceItemId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@RequestBody @Valid InvoiceItem invoiceItem){
        serviceLayer.updateInvoice(invoiceItem);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceItem> getAllInvoiceItems(){
        return serviceLayer.findAllInvoiceItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("invoice_id") int invoiceItemIdId){
        serviceLayer.removeInvoice(invoiceItemIdId);
    }

}