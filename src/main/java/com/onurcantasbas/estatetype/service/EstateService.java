package com.onurcantasbas.estatetype.service;


import com.onurcantasbas.estatetype.core.Estate;
import com.onurcantasbas.estatetype.core.House;
import com.onurcantasbas.estatetype.core.Villa;
import com.onurcantasbas.estatetype.repository.EstateRepository;
import com.onurcantasbas.estatetype.repository.dto.EstateDto;
import com.onurcantasbas.estatetype.repository.dto.mapping.DtoMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateService {

    private final EstateRepository estateRepository;
    private final DtoMapping dtoMapping;

    public EstateService(EstateRepository estateRepository, DtoMapping dtoMapping) {

        this.estateRepository = estateRepository;
        this.dtoMapping = dtoMapping;
    }

    public void saveEstate(EstateDto estateDto){
        Estate estate = dtoMapping.EstateDtoToEstate(estateDto);
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
    public Double getPriceSumByType(String type){
        return estateRepository.getPriceSumByType(type);
    }
    // Tüm tipteki evlerin fiyat toplamını döndürür.
    public Double getPriceSumAll(){
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
    public List<Estate> filterAllByHallAndRoom(int mimRooms,int maxRooms,int minHalls,int maxHalls ){
        return estateRepository.findAllByNumberOfRoomsBetweenAndNumberOfHallsBetween(mimRooms,maxRooms,minHalls,maxHalls);
    }







}
