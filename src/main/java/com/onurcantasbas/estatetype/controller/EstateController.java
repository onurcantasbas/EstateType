package com.onurcantasbas.estatetype.controller;

import com.onurcantasbas.estatetype.service.dao.EstateFilterDao;
import com.onurcantasbas.estatetype.service.dto.EstateDto;
import com.onurcantasbas.estatetype.service.EstateService;
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
    public int getPriceSumByType(@RequestParam String type){
        return estateService.getPriceSumByType(type);
    }
    @GetMapping("/v1/priceSumAll")
    public int getPriceSumAll(){
        return estateService.getPriceSumAll();
    }
    @GetMapping("/v1/sqrMtrAvgByType")
    @ResponseBody
    public double getSquareMetersAverageByType(@RequestParam String type){
        return estateService.getSquareMetersAverageByType(type);
    }
    @GetMapping("/v1/sqrMtrAvgAll")
    public double getSquareMetersAverageAll(){
        return estateService.getSquareMetersAverageAll();
    }
    @GetMapping("/v1/filterRangeEstate")
    @ResponseBody
    public List<EstateDto> filterRangeEstate(@RequestBody EstateFilterDao estateFilterDao){
        return estateService.filterAllByHallAndRoom(
                estateFilterDao.getMinRooms(),
                estateFilterDao.getMaxRooms(),
                estateFilterDao.getMinHalls(),
                estateFilterDao.getMaxHalls());
    }
    @GetMapping("/v1/filterEstate")
    @ResponseBody
    public List<EstateDto> filterEstate(@RequestBody EstateFilterDao estateFilterDao){
        return estateService.filterAllByHallAndRoom(
                estateFilterDao.getMinRooms(),
                estateFilterDao.getMinHalls()
        );
    }
}
