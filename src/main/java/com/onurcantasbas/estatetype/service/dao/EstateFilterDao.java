package com.onurcantasbas.estatetype.service.dao;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstateFilterDao {
    private int minRooms;
    private int maxRooms;
    private int minHalls;
    private int maxHalls;
}
