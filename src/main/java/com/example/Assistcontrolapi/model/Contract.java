package com.example.Assistcontrolapi.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table (name = "contract")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String contract_name;
    private String description;


}
