package com.example.practice.controller;

import com.example.practice.payload.BusOperatorDto;
import com.example.practice.service.BusOperatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusOperatorController {

    private BusOperatorService busOperatorService;
    public BusOperatorController(BusOperatorService busOperatorService){
        this.busOperatorService = busOperatorService;
    }

    @PostMapping
    public ResponseEntity<BusOperatorDto> createBus(@RequestBody BusOperatorDto busOperatorDto){
        BusOperatorDto dto = busOperatorService.createBus(busOperatorDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{busId}")
    public ResponseEntity<String>  deleteBusById( @PathVariable long busId){
        busOperatorService.deleteBusById(busId);
        return new ResponseEntity<>("Bus is Deleted", HttpStatus.OK);
    }
    @PutMapping("/{busId}")
    public ResponseEntity<BusOperatorDto> updateBus(
            @PathVariable long busId,
            @RequestBody BusOperatorDto busOperatorDto
    ){
        BusOperatorDto dto = busOperatorService.updateBus(busId, busOperatorDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public List<BusOperatorDto> getAllBusOperators(){
        List<BusOperatorDto> busOperatorDtos = busOperatorService.getAllBuses();
        return busOperatorDtos;
    }


}
