package com.company.U1M6Summative.Controller;


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
    public CustomerViewModel createCustomer(@RequestBody @Valid CustomerViewModel viewModel) {
        return serviceLayer.saveCustomer(viewModel);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomers() {
        List<CustomerViewModel> customerList = serviceLayer.findAllCustomers();

        return customerList;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel getCustomerById(@PathVariable("customerId") int customerId) {
        return serviceLayer.findCustomer(customerId);
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel updateCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerViewModel viewModel) {
        viewModel.setCustomerId(customerId);
        return serviceLayer.updateCustomer(viewModel);
    }

    @RequestMapping(value = "/{customerId}" , method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        serviceLayer.removeCustomer(customerId);
    }
}
