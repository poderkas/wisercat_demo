package com.example.pets;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Pets")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String color;

    private String type;

}
