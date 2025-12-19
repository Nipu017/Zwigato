package com.example.zwigato.controller;

import com.example.zwigato.dto.Response.MenuItemResponse;
import com.example.zwigato.dto.Response.RestaurantResponse;
import com.example.zwigato.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PostMapping
    public ResponseEntity addRestaurant(@RequestParam String name,
                                        @RequestParam String location)
    {
         RestaurantResponse responses =  restaurantService.addRestaurant(name,location);
         return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }

//    Api to get all menu items of a restaurant

    @GetMapping
    public ResponseEntity getAllMenu(@RequestParam int restaurantId)
    {
        try {
            List<MenuItemResponse> menuItems = restaurantService.getAllMenu(restaurantId);
            return new ResponseEntity<>(menuItems, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
