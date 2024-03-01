package com.example.practice.service;

import com.example.practice.payload.BusOperatorDto;

import java.util.List;

public interface BusOperatorService {
    BusOperatorDto createBus(BusOperatorDto busOperatorDto);
    void deleteBusById(long busId);
    BusOperatorDto updateBus(long busId, BusOperatorDto busOperatorDto);
    List<BusOperatorDto> getAllBuses();

}
