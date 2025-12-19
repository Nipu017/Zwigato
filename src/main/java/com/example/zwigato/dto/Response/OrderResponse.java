package com.example.zwigato.dto.Response;

import com.example.zwigato.utility.enums.OrderStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderResponse {

    private int totalCost;
    private Date createdAt;
    private OrderStatus status;
}
