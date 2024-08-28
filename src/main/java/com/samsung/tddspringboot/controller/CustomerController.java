package com.samsung.tddspringboot.controller;


import com.samsung.tddspringboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer-emails")
    public List<String> getCustomerEmails() {
        return customerService.getAllCustomerEmails();
    }
}
