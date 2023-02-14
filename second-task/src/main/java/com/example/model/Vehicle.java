package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicle {

    @Id
    Integer id;

    Double distance;

    @Column(name = "last_x")
    Integer lastX;

    @Column(name = "last_y")
    Integer lastY;
}
