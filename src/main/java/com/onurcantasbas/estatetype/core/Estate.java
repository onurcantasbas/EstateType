package com.onurcantasbas.estatetype.core;

import lombok.*;
import javax.persistence.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "estates")
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public abstract class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfHalls;
    private int price;
    @Column(name="type", insertable = false, updatable = false)
    private String type;
}
