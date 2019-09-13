package com.company.U1M6Summative.Controller;


import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody @Valid Customer viewModel) {
        return serviceLayer.saveCustomer(viewModel);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = serviceLayer.findAllCustomers();

        return customerList;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        return serviceLayer.findCustomer(customerId);
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        customer.setId(customerId);
        serviceLayer.updateCustomer(customer);
    }

    @RequestMapping(value = "/{customerId}" , method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        serviceLayer.removeInvoice(customerId);
    }
}
