package com.onurcantasbas.estatetype.service.dto;


import lombok.*;

import javax.persistence.Column;
@ToString
@Builder
@Setter
@Getter
@AllArgsConstructor
public class EstateDto {
    private Long id;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfHalls;
    private int price;
    private String type;
}
