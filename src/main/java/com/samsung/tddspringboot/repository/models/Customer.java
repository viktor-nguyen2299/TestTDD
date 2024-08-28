package com.samsung.tddspringboot.repository.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String Number;
    private String Name;

    private String Email;
}
