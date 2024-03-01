package com.example.practice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOperatorDto {
    private Long busId;
    private String busNumber;
    private String busOperatorCompanyName;

}
