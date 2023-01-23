package com.onurcantasbas.estatetype.core;

import lombok.Builder;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SummerHouse")
public class SummerHouse extends Estate{
    @Builder
    public SummerHouse(Long id, int squareMeters, int numberOfRooms, int numberOfHalls, int price, String type) {
        super(id, squareMeters, numberOfRooms, numberOfHalls, price,type);
    }

    public SummerHouse() {
    }
}
