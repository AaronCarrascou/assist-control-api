package com.example.Assistcontrolapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employee_name;
    private String address;
    private String cell_number;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Positions position;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;


}
