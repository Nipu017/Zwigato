package com.example.zwigato.controller;


import com.example.zwigato.dao.AddressRepository;
import com.example.zwigato.dto.Request.AddressRequest;
import com.example.zwigato.dto.Response.AddressResponse;
import com.example.zwigato.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity addAddress(@RequestParam int customerId,
                                     @RequestBody AddressRequest addressRequest)
    {
        try{
            AddressResponse addressResponse = addressService.addAddress(customerId, addressRequest);
            return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
