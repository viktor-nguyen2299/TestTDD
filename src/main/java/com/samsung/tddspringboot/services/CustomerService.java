package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<String> getAllCustomerEmails() {
        return customerRepository.findAllEmails();
    }

    public boolean emailExists(String email) {
        List<String> emails = getAllCustomerEmails();
        return emails.contains(email);
    }

}
