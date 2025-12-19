package com.example.zwigato.service;

import com.example.zwigato.dao.AddressRepository;
import com.example.zwigato.dao.CustomerRepository;
import com.example.zwigato.dto.Request.AddressRequest;
import com.example.zwigato.dto.Response.AddressResponse;
import com.example.zwigato.exception.CustomerNotFoundException;
import com.example.zwigato.model.Address;
import com.example.zwigato.model.Customer;
import com.example.zwigato.utility.transformers.AddressTransformer;
import com.example.zwigato.utility.transformers.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public AddressResponse addAddress(int customerId,AddressRequest addressRequest) {

        Optional<Customer>optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Invalid CustomerId "+ customerId);

        Customer customer = optionalCustomer.get();
        Address address = AddressTransformer.AddressRequestToAddress(addressRequest);

        customer.getAddress().add(address);

        Customer savedCustomer = customerRepository.save(customer);

        int size = savedCustomer.getAddress().size();
        Address lastSavedAddress = savedCustomer.getAddress().get(size-1);

        AddressResponse response =  AddressTransformer.AddressToAddressResponse(lastSavedAddress);
        response.setCustomer(CustomerTransformer.CustomerToCustomerResponse(savedCustomer));
        return response;

    }
}
