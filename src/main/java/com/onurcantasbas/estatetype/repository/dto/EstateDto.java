package com.onurcantasbas.estatetype.repository.dto;


import lombok.*;

import javax.persistence.Column;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstateDto {
    private Long id;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfHalls;
    private int price;
    private String type;
}
