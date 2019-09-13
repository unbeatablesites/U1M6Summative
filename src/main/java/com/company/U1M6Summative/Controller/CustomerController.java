//package com.company.U1M6Summative.Controller;
//
//
//import com.company.U1M6Summative.dto.Customer;
//import com.company.U1M6Summative.service.ServiceLayer;
//import com.company.U1M6Summative.viewmodel.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/customer")
//
//public class CustomerController {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Customer createCustomer(@RequestBody @Valid Customer viewModel) {
//        return serviceLayer.saveCustomer(viewModel);
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Customer> getAllCustomers() {
//        List<Customer> customerList = serviceLayer.findAllCustomers();
//
//        return customerList;
//    }
//
//    @GetMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
//        return serviceLayer.findCustomer(customerId);
//    }
//
//    @PutMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer viewModel) {
//        viewModel.setCustomerId(customerId);
//        return serviceLayer.updateCustomer(viewModel);
//    }
//
//    @DeleteMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteCustomer(@PathVariable("customerId") int customerId) {
//        serviceLayer.removeCustomer(customerId);
//    }
//}
