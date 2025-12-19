package com.example.zwigato.dto.Request;

import com.example.zwigato.utility.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuItemRequest {

    private String name;

    private int price;

    private FoodCategory category;

    private boolean Veg;
}
