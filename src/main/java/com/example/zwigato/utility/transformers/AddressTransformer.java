package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.Request.AddressRequest;
import com.example.zwigato.dto.Response.AddressResponse;
import com.example.zwigato.model.Address;

public class AddressTransformer {

    public static Address AddressRequestToAddress(AddressRequest addressRequest)
    {
        return Address.builder()
                .houseNo(addressRequest.getHouseNo())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static AddressResponse AddressToAddressResponse(Address address)
    {
        return AddressResponse.builder()
                .houseNo(address.getHouseNo())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .build();
    }

}
