package com.example.zwigato.service;

import com.example.zwigato.dao.MenuItemRepository;
import com.example.zwigato.dao.RestaurantRepository;
import com.example.zwigato.dto.Request.MenuItemRequest;
import com.example.zwigato.exception.RestaurantNotFoundException;
import com.example.zwigato.model.MenuItem;
import com.example.zwigato.model.Restaurant;
import com.example.zwigato.utility.transformers.MenuItemTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final RestaurantRepository restaurantRepository;

    public String addMenuItems(int restaurantId, MenuItemRequest menuItemRequest) {

        Optional<Restaurant>optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isEmpty())
        {
            throw new RestaurantNotFoundException("Invalid Restaurantid "+ restaurantId);
        }


        Restaurant restaurant = optionalRestaurant.get();
        MenuItem menuItem = MenuItemTransformer.MenuItemRequestToMenuItem(menuItemRequest);

        menuItem.getRestaurants().add(restaurant);
        restaurant.getMenuItem().add(menuItem);
        restaurantRepository.save(restaurant);

        return "Menu items added!!";
    }
}
