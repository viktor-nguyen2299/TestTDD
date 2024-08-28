package com.samsung.tddspringboot.repository;

import com.samsung.tddspringboot.repository.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<String> findAllEmails();
}
/*public class CustomerRepository {
    public Account getCustomerByEmail(String customerEmail) {
        throw new RuntimeException("Customer Not Found");
    }
    public Customer validateCustomerByEmail(String customerEmail) {
        throw new RuntimeException("Email is invalid, try again");
    }

    public Customer getAllCustomer() {

        List<String> findAllEmails();
    }
}*/
