package com.onurcantasbas.estatetype;

import com.onurcantasbas.estatetype.repository.EstateRepository;
import com.onurcantasbas.estatetype.service.EstateService;
import com.onurcantasbas.estatetype.service.dto.EstateDto;
import com.onurcantasbas.estatetype.service.dto.mapping.DtoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

import static java.lang.Long.valueOf;


@SpringBootApplication
public class EstateTypeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EstateTypeApplication.class, args);
    }
    @Autowired
    EstateService estateService;
    @Autowired
    EstateRepository estateRepository;
    @Autowired
    DtoMapping dtoMapping;
    @Override
    public void run(String... args) throws Exception {
        /*
    Generate And Save Entity With random values
          for(int i=0;i<50;i++){
            if(i%3==0){
                Estate villa = Villa.builder()
                        .price((int)(Math.random()*100000)+10000)
                        .numberOfHalls((int)(Math.random()*5)+1)
                        .squareMeters((int)(Math.random()*1000)+100)
                        .numberOfRooms((int)(Math.random()*20)+1)
                .build();
                estateService.saveEstate(villa);
             }else if (i%3==1) {
                Estate house = House.builder()
                        .price((int)(Math.random()*100000)+10000)
                        .numberOfHalls((int)(Math.random()*5)+1)
                       .squareMeters((int)(Math.random()*1000)+100)
                        .numberOfRooms((int)(Math.random()*20)+1)
                        .build();
                estateService.saveEstate(house);
             }else {
                Estate summerHouse = SummerHouse.builder()
                        .price((int)(Math.random()*100000)+10000)
                        .numberOfHalls((int)(Math.random()*5)+1)
                        .squareMeters((int)(Math.random()*1000)+100)
                        .numberOfRooms((int)(Math.random()*20)+1)
                        .build();
                estateService.saveEstate(summerHouse);
            }
        }
        //Generate And Save Entity Manual
        EstateDto c = EstateDto.builder()
                .numberOfRooms(30)
                .squareMeters(30)
                .numberOfHalls(30)
                .price(30)
                .type("Villa")
                .build();
        estateRepository.save(dtoMapping.estateDtoToEstate(c));

*/
        double avgAll = estateService.getSquareMetersAverageAll();
        System.out.println("Square Meters Average of All = "+ avgAll);

        double avgSqrtSummerHouse = estateService.getSquareMetersAverageByType("SummerHouse");
        System.out.println("Square Meters Average of SummerHouse = "+ avgSqrtSummerHouse);

        double avgSqrtHouse = estateService.getSquareMetersAverageByType("House");
        System.out.println("Square Meters Average of House = "+ avgSqrtHouse);

        double avgSqrtVilla = estateService.getSquareMetersAverageByType("Villa");
        System.out.println("Square Meters Average of Villa = "+ avgSqrtVilla);

        double sumAll = estateService.getPriceSumAll();
        System.out.println("Price Sum of All = "+ sumAll);

        double sumSummerHouse = estateService.getPriceSumByType("SummerHouse");
        System.out.println("Price Sum of SummerHouse = "+ sumSummerHouse);

        double sumHouse = estateService.getPriceSumByType("House");
        System.out.println("Price Sum of House = "+ sumHouse);

        double sumVilla = estateService.getPriceSumByType("Villa");
        System.out.println("Price Sum of Villa = "+ sumVilla);

        System.out.println("--------------------Room And Hall Filter By Range-----------------------");
        List<EstateDto> estatesFilteredByRange = estateService.filterAllByHallAndRoom(2,5,4,8);
        if(estatesFilteredByRange.size()!=0){
            for (EstateDto estateDto:estatesFilteredByRange
            ) {
                System.out.println("EntityId:" +estateDto.getId()+ " numberOfHall = "+estateDto.getNumberOfHalls()+ " numberOfRoom = "+estateDto.getNumberOfRooms());
            }
        }else{
            System.out.println("Aradığınız oda ve salon aralığında emlak bulunamadı.");
        }

        System.out.println("-----------------------Room And Hall Filter----------------------------");
        List<EstateDto> estatesFiltered = estateService.filterAllByHallAndRoom(10,5);
        if(estatesFiltered.size()!=0){
        for (EstateDto estateDto:estatesFiltered
             ) {
            System.out.println("EntityId:" +estateDto.getId()+ " numberOfHall = "+estateDto.getNumberOfHalls()+ " numberOfRoom = "+estateDto.getNumberOfRooms());
        }
        }else{
            System.out.println("Aradığınız oda ve salon sayısına sahip emlak bulunamadı.");
        }
    }
}
