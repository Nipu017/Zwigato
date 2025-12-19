package com.example.zwigato.service;

import com.example.zwigato.dao.RestaurantRepository;
import com.example.zwigato.dto.Response.MenuItemResponse;
import com.example.zwigato.dto.Response.RestaurantResponse;
import com.example.zwigato.exception.RestaurantNotFoundException;
import com.example.zwigato.model.MenuItem;
import com.example.zwigato.model.Restaurant;
import com.example.zwigato.utility.transformers.MenuItemTransformer;
import com.example.zwigato.utility.transformers.RestaurantTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(String name, String location) {

        Restaurant restaurant = Restaurant.builder()
                .name(name)
                .location(location)
                .isOpen(true)
                .registeredAt(new Date())
                .menuItem(new ArrayList<>())
                .build();

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }


    public List<MenuItemResponse> getAllMenu(int restaurantId) {

        Optional<Restaurant>optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isEmpty())
        {
            throw new RestaurantNotFoundException("Invalid RestaurantId "+restaurantId);
        }

        Restaurant restaurant = optionalRestaurant.get();

        List<MenuItem>menuItems = restaurant.getMenuItem();

//        List<MenuItemResponse>MenuItemResponses = new ArrayList<>();
//
//        for(MenuItem menuItem: menuItems)
//        {
//            MenuItemResponses.add(MenuItemTransformer.MenuItemToMenuItemResponse(menuItem));
//        }


//        using stream
        List<MenuItemResponse> menuItemResponses = menuItems.stream()
                .map(MenuItemTransformer::MenuItemToMenuItemResponse)
                .collect(Collectors.toList());

        return menuItemResponses;
    }
}
