package br.com.meli.crudanimalmeli.repositories;

import br.com.meli.crudanimalmeli.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Optional<Animal> findByName(String name);

    List<Animal> findByColor(String color);
}
