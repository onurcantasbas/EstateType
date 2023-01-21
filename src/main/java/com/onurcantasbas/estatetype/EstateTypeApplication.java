package com.onurcantasbas.estatetype;


import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.core.House;
import com.onurcantasbas.estatetype.core.SummerHouse;
import com.onurcantasbas.estatetype.core.Villa;
import com.onurcantasbas.estatetype.repository.EstateRepository;
import com.onurcantasbas.estatetype.repository.dto.EstateDto;
import com.onurcantasbas.estatetype.service.EstateService;
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

    @Override
    public void run(String... args) throws Exception {

/*
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
*/

//        double avgAll = estateService.getSquareMetersAverageAll();
//        double avgSqrtSummerHouse = estateService.getSquareMetersAverageByType("SummerHouse");
//        double avgSqrtHouse = estateService.getSquareMetersAverageByType("House");
//        double avgSqrtVilla = estateService.getSquareMetersAverageByType("Villa");
//
//        double sumAll = estateService.getPriceSumAll();
//        double sumSummerHouse = estateService.getPriceSumByType("SummerHouse");
//        double sumHouse = estateService.getPriceSumByType("House");
//        double sumVilla = estateService.getPriceSumByType("Villa");
//
//        List<Estate> estatesFiltered = estateService.filterAllByHallAndRoom(2,5,4,8);
//
//        System.out.println("average All = "+ avgAll);
//        System.out.println("average SummerHouse = "+ avgSqrtSummerHouse);
//        System.out.println("average House = "+ avgSqrtHouse);
//        System.out.println("average Villa = "+ avgSqrtVilla);
//
//        System.out.println("sum All = "+ sumAll);
//        System.out.println("sum SummerHouse = "+ sumSummerHouse);
//        System.out.println("sum House = "+ sumHouse);
//        System.out.println("sum Villa = "+ sumVilla);
//
//        Estate c = Villa.builder()
//                .numberOfRooms(30)
//                .squareMeters(30)
//                .numberOfHalls(30)
//                .price(30)
//                .build();
//        estateRepository.save(c);
//
//        System.out.println("ilk Hali :"+c.getClass().getSimpleName());
//
//        Estate last = estateRepository.findById(52L).orElseThrow(null);
//        System.out.println("Geri dönüşü :"+last.getClass().getSimpleName());






//        for (Estate estate:estatesFiltered
//             ) {
//            System.out.println("EntityId:" +estate.getId()+ " numberOfHall = "+estate.getNumberOfHalls());
//            System.out.println("EntityId:" +estate.getId()+ " numberOfRoom = "+estate.getNumberOfRooms());
//            System.out.println(estate.getClass().getSimpleName());
//           }


    }
}
