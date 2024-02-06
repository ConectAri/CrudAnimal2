package br.com.meli.crudanimalmeli.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //O método toString() é um método especial em Java que retorna uma representação em string do objeto. É útil para depuração e
// registro, pois permite que você imprima informações sobre o objeto de uma maneira legível.
public class AnimalDto {
    private String name;
    private String color;
    private Integer age;
}