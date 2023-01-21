package com.onurcantasbas.estatetype.repository.dto.mapping;

import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.core.House;
import com.onurcantasbas.estatetype.core.SummerHouse;
import com.onurcantasbas.estatetype.core.Villa;
import com.onurcantasbas.estatetype.repository.dto.EstateDto;
import org.hibernate.mapping.Subclass;
import org.springframework.context.annotation.Configuration;




@Configuration
public class DtoMapping {
    public Estate EstateDtoToEstate(EstateDto estateDto){

        if(estateDto.getType()=="House") {
            return House.builder()
                    .squareMeters(estateDto.getSquareMeters())
                    .numberOfRooms(estateDto.getNumberOfRooms())
                    .numberOfHalls(estateDto.getNumberOfHalls())
                    .price(estateDto.getPrice())
                    .build();
        }if(estateDto.getType()=="Villa"){
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
    public EstateDto EstateToEstateDto(Estate estate){
        return EstateDto.builder()
                .squareMeters(estate.getSquareMeters())
                .numberOfRooms(estate.getNumberOfRooms())
                .numberOfHalls(estate.getNumberOfHalls())
                .price(estate.getPrice())
                .type(estate.getType())
                .build();

    }

}
