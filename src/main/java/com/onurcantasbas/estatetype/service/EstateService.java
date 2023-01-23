package com.onurcantasbas.estatetype.service;


import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.repository.EstateRepository;
import com.onurcantasbas.estatetype.service.dto.EstateDto;
import com.onurcantasbas.estatetype.service.dto.mapping.DtoMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class EstateService {

    private final EstateRepository estateRepository;
    private final DtoMapping dtoMapping;

    public EstateService(EstateRepository estateRepository, DtoMapping dtoMapping) {

        this.estateRepository = estateRepository;
        this.dtoMapping = dtoMapping;
    }

    public void saveEstate(EstateDto estateDto){
        Estate estate = dtoMapping.estateDtoToEstate(estateDto);
        estateRepository.save(estate);
    }
    public void deleteEstate(Estate estate){
        estateRepository.delete(estate);
    }

//    public List<Estate> findAll(){return estateRepository.findAll();}
//    public List<Estate> findAllByType(String type) {
//        return estateRepository.findAllByType(type);
//    }

    // Belirtilen tipteki evlerin fiyat toplamını döndürür.
    public int getPriceSumByType(String type){
        return estateRepository.getPriceSumByType(type);
    }
    // Tüm tipteki evlerin fiyat toplamını döndürür.
    public int getPriceSumAll(){
        return estateRepository.getPriceSumOfAll();
    }

    // Belirtilen tipteki evlerin metre karesinin ortalamasını döndürür.
    public Double getSquareMetersAverageByType(String type){
        return estateRepository.getSqueraMetersAverageByType(type);
    }

    // Tüm tipteki evlerin metre karesinin ortalamasını döndürür.
    public Double getSquareMetersAverageAll(){
        return estateRepository.getSqueraMetersAverageOfAll();
    }

    // Tüm tipteki evleri salon ve oda sayısı aralığına göre filtreler 4 parametre gerekli
    // oda aralığı int mimRooms,int maxRooms ve salon aralığı int minHalls,int maxHalls
    public List<EstateDto> filterAllByHallAndRoom(int mimRooms,int maxRooms,int minHalls,int maxHalls ){
        return dtoMapping.estateListToEstateDtoList(estateRepository.findAllByNumberOfRoomsBetweenAndNumberOfHallsBetween(mimRooms,maxRooms,minHalls,maxHalls));
    }
    // Tüm tipteki evleri salon ve oda sayısına göre filtreler
    public List<EstateDto> filterAllByHallAndRoom(int numberOfRooms, int numberOfHalls){
        return dtoMapping.estateListToEstateDtoList(estateRepository.findAllByNumberOfRoomsAndNumberOfHalls(numberOfRooms,numberOfHalls));
    }
}
