package com.example.zwigato.service;

import com.example.zwigato.dao.CustomerRepository;
import com.example.zwigato.dao.MenuItemRepository;
import com.example.zwigato.dao.OrderEntityRepository;
import com.example.zwigato.dto.Request.OrderItemRequest;
import com.example.zwigato.dto.Response.OrderResponse;
import com.example.zwigato.exception.CustomerNotFoundException;
import com.example.zwigato.model.*;
import com.example.zwigato.model.MenuItem;
import com.example.zwigato.utility.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderEntityService {

    private final OrderEntityRepository orderEntityRepository;
    private final CustomerRepository customerRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderResponse placeAnOrder(int customerId, List<OrderItemRequest> orderItemRequests) {

        Optional<Customer>optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid CustomerId "+customerId);
        }

        Customer customer = optionalCustomer.get();


        List<MenuItem>menuItems = new ArrayList<>();
        int totalCost =0;
        List<OrderItem>orderItems = new ArrayList<>();

        OrderEntity orderEntity = new OrderEntity();

        for(OrderItemRequest request : orderItemRequests)
        {
            MenuItem menuItem = menuItemRepository.findById(request.getMenuItemId()).get();
            totalCost += menuItem.getPrice()*request.getQuantity();
            menuItems.add(menuItem);

            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(request.getQuantity());
            orderItem.setOrderEntity(orderEntity);
            orderItems.add(orderItem);
        }

        orderEntity.setStatus(OrderStatus.PLACED);
        orderEntity.setTotalCost(totalCost);
        orderEntity.setCustomer(customer);
        orderEntity.setOrderItems(orderItems);

        OrderEntity savedOrder = orderEntityRepository.save(orderEntity);

        return OrderResponse.builder()
                .totalCost((int) savedOrder.getTotalCost())
                .status(savedOrder.getStatus())
                .createdAt(savedOrder.getCreatedAt())
                .build();
    }
}
