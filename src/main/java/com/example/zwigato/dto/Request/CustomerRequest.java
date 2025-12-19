package com.example.zwigato.dto.Request;

import com.example.zwigato.utility.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerRequest {

    private String name;

    private String mobNo;

    private Gender gender;
}
