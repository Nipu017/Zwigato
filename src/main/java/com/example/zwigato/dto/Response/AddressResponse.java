package com.example.zwigato.dto.Response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressResponse {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;

    private CustomerResponse customer;
}
