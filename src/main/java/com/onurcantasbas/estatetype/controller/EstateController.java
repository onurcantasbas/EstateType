package com.onurcantasbas.estatetype.controller;

import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.repository.dto.EstateDto;
import com.onurcantasbas.estatetype.service.EstateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value="/estate")
public class EstateController {
    private final EstateService estateService;

    public EstateController(EstateService estateService) {
        this.estateService = estateService;

    }
    @PostMapping("/v1/saveEstate")
    public void saveEstate(@RequestBody EstateDto estateDto){
        estateService.saveEstate(estateDto);
    }
    @GetMapping("/v1/priceSumByType")
    public double getPriceSumByType(@RequestBody String type){
        return estateService.getPriceSumByType(type);
    }
    @GetMapping("/v1/priceSumAll")
    public double getPriceSumAll(){
        return estateService.getPriceSumAll();
    }
    @GetMapping("/v1/sqrMtrAvgByType")
    @ResponseBody
    public double getSquareMetersAverageByType(@RequestBody String type){
        return estateService.getSquareMetersAverageByType(type);
    }
    @GetMapping("/v1/sqrMtrAvgAll")
    public double getSquareMetersAverageAll(){
        return estateService.getSquareMetersAverageAll();
    }
    @GetMapping("/v1/filterEstate")
    public List<Estate> filterEstate(@RequestBody int minRooms,int maxRooms,int minHalls,int maxHalls){
        List<Estate> holder = estateService.filterAllByHallAndRoom(minRooms,maxRooms,minHalls,maxHalls);
        return holder;
    }





}
