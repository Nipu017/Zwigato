package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.Request.CustomerRequest;
import com.example.zwigato.dto.Response.CustomerResponse;
import com.example.zwigato.model.Customer;

import java.util.ArrayList;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer( CustomerRequest customerRequest)
    {
         return Customer.builder()
                 .name(customerRequest.getName())
                 .mobNo(customerRequest.getMobNo())
                 .gender(customerRequest.getGender())
                 .address(new ArrayList<>())
                 .orders(new ArrayList<>())
                 .build();
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer)
    {
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .build();
    }


}
