package com.example.zwigato.dto.Response;

import com.example.zwigato.model.Restaurant;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RestaurantResponse {

    String name;
    String location;
    boolean isOpen;
    Date registeredAt;
}
