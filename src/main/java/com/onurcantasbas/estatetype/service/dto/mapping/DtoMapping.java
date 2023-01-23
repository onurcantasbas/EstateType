package com.onurcantasbas.estatetype.service.dto.mapping;

import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.core.House;
import com.onurcantasbas.estatetype.core.SummerHouse;
import com.onurcantasbas.estatetype.core.Villa;
import com.onurcantasbas.estatetype.service.dto.EstateDto;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class DtoMapping {
    public Estate estateDtoToEstate(EstateDto estateDto){

        if(estateDto.getType().equalsIgnoreCase("House")) {
            return House.builder()
                    .squareMeters(estateDto.getSquareMeters())
                    .numberOfRooms(estateDto.getNumberOfRooms())
                    .numberOfHalls(estateDto.getNumberOfHalls())
                    .price(estateDto.getPrice())
                    .build();
        }if(estateDto.getType().equalsIgnoreCase("Villa")){
            return  Villa.builder()
                    .squareMeters(estateDto.getSquareMeters())
                    .numberOfRooms(estateDto.getNumberOfRooms())
                    .numberOfHalls(estateDto.getNumberOfHalls())
                    .price(estateDto.getPrice())
                    .build();
        }else{
            return  SummerHouse.builder()
                    .squareMeters(estateDto.getSquareMeters())
                    .numberOfRooms(estateDto.getNumberOfRooms())
                    .numberOfHalls(estateDto.getNumberOfHalls())
                    .price(estateDto.getPrice())
                    .build();
        }
    }
    public EstateDto estateToEstateDto(Estate estate){
        return EstateDto.builder()
                .id(estate.getId())
                .squareMeters(estate.getSquareMeters())
                .numberOfRooms(estate.getNumberOfRooms())
                .numberOfHalls(estate.getNumberOfHalls())
                .price(estate.getPrice())
                .type(estate.getType())
                .build();

    }
    public List<EstateDto> estateListToEstateDtoList(List<Estate> estates){
        List<EstateDto> dtoHolder = new ArrayList<>();
        for (Estate estate:estates
             ) {
            dtoHolder.add(estateToEstateDto(estate));
        }
        return dtoHolder;
    }
}
