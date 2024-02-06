package br.com.meli.crudanimalmeli.services;

import br.com.meli.crudanimalmeli.entities.Animal;

import java.util.List;

public interface AnimalService {  //Interface é contrato

    Animal create(String name, Integer age, String color);

    void delete(Integer id);

    Animal update(Integer id, String name, Integer age, String color);

    Animal findAnimal(Integer id);

    Animal findAnimalByName(String name);

    List<Animal> findAnimalByColor(String color);

    List<Animal> findAll();

    List<Animal> findAllByAge(Integer age);//Lista de animais por idade


}

