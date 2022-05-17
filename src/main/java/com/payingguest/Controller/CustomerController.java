package com.payingguest.Controller;

import com.payingguest.model.Customer;
import com.payingguest.model.PayingGuest;
import com.payingguest.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer-api")
public class CustomerController {

    ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public Customer addPayingGuest(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customer-booking/customerId/{customerId}")
    public void updateCustomer(@PathVariable("customerId")int customerId){
         customerService.updateCustomer(customerId);
    }


}
