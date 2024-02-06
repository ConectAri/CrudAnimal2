package br.com.meli.crudanimalmeli.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "ANIMAL") //Fala qual o nome da nossa tabela
@Getter
@Setter
@NoArgsConstructor
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //@GeneretValue serve para criar automaticamente o ID
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    // TODO: transform to ENUM
    @Column(name = "COLOR")
    private String color;

    public Animal(String dog, String black) {
    }

    public Animal(String expectedName, String expectedColor, Integer expectedAge) {
        this.name = expectedName;
        this.color = expectedColor;
        this.age = expectedAge;
    }
}
