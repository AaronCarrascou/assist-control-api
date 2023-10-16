package com.example.Assistcontrolapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "positions")
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String position_name;
    private String description;
}
