package com.onurcantasbas.estatetype.core;

import lombok.Builder;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Villa")
public class Villa extends Estate{

    @Builder
    public Villa(Long id, int squareMeters, int numberOfRooms, int numberOfHalls, int price, String type) {
        super(id, squareMeters, numberOfRooms, numberOfHalls, price, type);
    }



    public Villa() {
    }
}
