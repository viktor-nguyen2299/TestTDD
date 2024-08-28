package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.controller.CustomerController;
import com.samsung.tddspringboot.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Test
    public void testGetCustomerEmails() throws Exception {
        // Arrange
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        Mockito.when(customerService.getAllCustomerEmails())
                .thenReturn(Arrays.asList("long@java.com", "anan@java.com"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/customer-emails"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("long@java.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("anan@java.com"));
    }
}
