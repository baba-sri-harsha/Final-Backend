package com.payingguest.service;

import com.payingguest.model.Customer;
import com.payingguest.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int id) {

    }

    @Override
    public Customer getByCustomerId(int id) {
        return customerRepository.getById(id);
    }


}
