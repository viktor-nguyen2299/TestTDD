package com.samsung.tddspringboot.services;


import com.samsung.tddspringboot.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {
    @Mock //mock implementation for Repository
    private CustomerRepository customerRepository;

    @InjectMocks //Inject
    private CustomerService customerService;

    @Test
    public void should_return_email_already_exists() {
        // Arrange
        String emailToFind = "long@java.com";
        List<String> mockEmails = Arrays.asList("long@java.com", "an@java.com");
        when(customerRepository.findAllEmails()).thenReturn(mockEmails);

        // Act
        boolean exists = customerService.emailExists(emailToFind);

        // Assert
        assertFalse(exists, "Email should not exist in the list");
    }

    @Test
    public void should_return_email_does_not_exists() {
        // Arrange
        String emailToFind = "long99@java.org";
        List<String> mockEmails = Arrays.asList("anan@java.com", "eoeo@java.com");
        when(customerRepository.findAllEmails()).thenReturn(mockEmails);

        // Act
        boolean exists = customerService.emailExists(emailToFind);

        // Assert
        assertFalse(exists, "Email should not exist in the list");
    }
}
