package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor //Auto making the constructors,using lombok
@Data //Auto getter setters

public class User { //If this is entity we should provide the primary key-->ID
    @Id
    private int id;
    private String name;
    private String address;


}
