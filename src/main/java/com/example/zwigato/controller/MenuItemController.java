package com.example.zwigato.controller;

import com.example.zwigato.dto.Request.MenuItemRequest;
import com.example.zwigato.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menuItem")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping("/restaurant")
    public ResponseEntity addMenuItems(@RequestParam int RestaurantId,
                                       @RequestBody MenuItemRequest menuItemRequest)
    {
          try {
              String response = menuItemService.addMenuItems(RestaurantId, menuItemRequest);
              return new ResponseEntity<>(response,HttpStatus.CREATED);
          }
          catch (Exception e)
          {
              return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
          }

    }

}
