package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.Request.MenuItemRequest;
import com.example.zwigato.dto.Response.MenuItemResponse;
import com.example.zwigato.model.MenuItem;

import java.util.ArrayList;

public class MenuItemTransformer {

    public static MenuItem MenuItemRequestToMenuItem(MenuItemRequest menuItemRequest)
    {
        return MenuItem.builder()
                .name(menuItemRequest.getName())
                .price(menuItemRequest.getPrice())
                .veg(menuItemRequest.isVeg())
                .category(menuItemRequest.getCategory())
                .restaurants(new ArrayList<>())
                .build();
    }

    public static MenuItemResponse MenuItemToMenuItemResponse(MenuItem menuItem)
    {
        return MenuItemResponse.builder()
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .Veg(menuItem.isVeg())
                .category(menuItem.getCategory())
                .build();
    }
}
