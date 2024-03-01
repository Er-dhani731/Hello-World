package com.example.practice.service;
import com.example.practice.entity.BusOperator;
import com.example.practice.payload.BusOperatorDto;
import com.example.practice.repository.BusOperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {
    private BusOperatorRepository busOperatorRepository;

    public BusOperatorServiceImpl(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    @Override
    public BusOperatorDto createBus(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapToEntity(busOperatorDto);//It will call Dto-Entity method
        BusOperator savedBusOperator = busOperatorRepository.save(busOperator);
        BusOperatorDto dto = mapToDto(savedBusOperator);//It will call Entity-Dto method
        return dto;
    }

    //This method will convert Dto-Entity
    BusOperator mapToEntity(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = new BusOperator();
        busOperator.setBusNumber(busOperatorDto.getBusNumber()); // Corrected method and variable names
        busOperator.setBusOperatorCompanyName(busOperatorDto.getBusOperatorCompanyName());
        return busOperator;
    }

    //This method will covert Entity-Dto
    BusOperatorDto mapToDto(BusOperator savedBusOperator) {
        BusOperatorDto busOperatorDto = new BusOperatorDto();
        busOperatorDto.setBusId(savedBusOperator.getBusID());  // Use getBusID() for the ID field
        busOperatorDto.setBusNumber(savedBusOperator.getBusNumber());
        busOperatorDto.setBusOperatorCompanyName(savedBusOperator.getBusOperatorCompanyName());
        return busOperatorDto;
    }



    @Override
    public void deleteBusById(long busId) {
        busOperatorRepository.deleteById(busId);
    }

    @Override
    public BusOperatorDto updateBus(long busId, BusOperatorDto busOperatorDto) {
        BusOperator busOperator = busOperatorRepository.findById(busId).get();

        //For updating first i have to find the information based on id and then i can update
        //those information...

      // busOperator.setBusId(busOperatorDto.getBusId());
        busOperator.setBusNumber(busOperatorDto.getBusNumber());
        busOperator.setBusOperatorCompanyName(busOperatorDto.getBusOperatorCompanyName());
        BusOperator savedBusOperator = busOperatorRepository.save(busOperator);
        BusOperatorDto dto = mapToDto(savedBusOperator);
        return dto;
    }

    @Override
    public List<BusOperatorDto> getAllBuses() {
        List<BusOperator> busOperators = busOperatorRepository.findAll();
        List<BusOperatorDto> busOperatorDtos = busOperators.stream().map(busOperator -> mapToDto(busOperator))
                .collect(Collectors.toList());
        return busOperatorDtos;
    }
}
