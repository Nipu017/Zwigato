package com.example.zwigato.controller;

import com.example.zwigato.dto.Request.OrderItemRequest;
import com.example.zwigato.dto.Response.OrderResponse;
import com.example.zwigato.service.OrderEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderEntityController {

    private final OrderEntityService orderEntityService;

     @PostMapping
     public ResponseEntity placeAnOrder(@RequestParam("customer_id") int customerId,
                                        @RequestBody List<OrderItemRequest> orderItemRequests)
     {
          try{
              OrderResponse response = orderEntityService.placeAnOrder(customerId,orderItemRequests);
              return new ResponseEntity<>(response,HttpStatus.CREATED);
          }
          catch (Exception e)
          {
              return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
          }
     }
}
