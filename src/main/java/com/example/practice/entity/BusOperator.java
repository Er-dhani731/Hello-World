package com.example.practice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_operators")
public class BusOperator {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;
    @Column(name = "bus_number")
    private String busNumber;
    @Column(name = "bus_operator_company_name")
    private String busOperatorCompanyName;
}
