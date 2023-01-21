package com.onurcantasbas.estatetype.core;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.objenesis.instantiator.annotations.Instantiator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.lang.annotation.Inherited;




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
