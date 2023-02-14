package com.example.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignalsInput {

    @NotNull
    Integer id;
    @NotNull
    Integer x;
    @NotNull
    Integer y;

}
