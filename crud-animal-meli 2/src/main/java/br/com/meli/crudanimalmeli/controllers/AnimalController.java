package br.com.meli.crudanimalmeli.controllers;

import br.com.meli.crudanimalmeli.dto.AnimalDto;
import br.com.meli.crudanimalmeli.entities.Animal;
import br.com.meli.crudanimalmeli.services.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@RestController
@Slf4j //Significa que vai ter um log
public class AnimalController {

    private final AnimalService service;

    @PostMapping(value = "/animals/create")
    public ResponseEntity<Animal> create(@RequestBody Animal animal) {
      log.info("Começando controller");
      Animal createdAnimal = service.create(animal.getName(),
                                            animal.getAge(),
                                            animal.getColor());

      log.info("Terminando controller");


      return ResponseEntity.ok(createdAnimal);
    }

    @GetMapping(path = "/animals")
    public ResponseEntity<List<Animal>> findAll() {
        log.info("Encontrando todos os animais do banco");
        List<Animal> animalsFound = service.findAll();

        return ResponseEntity.ok(animalsFound);
    }

    @GetMapping("/animals/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Integer id) {
        log.info("Encontrando animal por id");
        Animal found = service.findAnimal(id);

        if (isNull(found)) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok(found);
        }
    }

    @GetMapping("/animals/byname")
    public ResponseEntity<Animal> findByName(@RequestParam String name) {
        log.info("Encontrando animal por nome");
        Animal found = service.findAnimalByName(name);

        if (isNull(found)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(found);
    }

    @GetMapping("/animals/color")
    public ResponseEntity<List<Animal>> findByColor(@RequestParam String color) {
        log.info("Encontrando animais por cor");
        List<Animal> found = service.findAnimalByColor(color);

        if (isNull(found)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(found);
    }

    //Criar metodo deletar animal
    @DeleteMapping("/animals/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        log.info("Deletando animal por id");
        Animal found = service.findAnimal(id);

        if (isNull(found)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return ResponseEntity.ok("Animal com id " + id + " deletado com sucesso");
    }


    @PutMapping("/animals/{id}")    //@PutMapping significa que é um metodo put
    public ResponseEntity<Animal> update(@PathVariable Integer id, @RequestBody AnimalDto animalDto) { //@RequestBody significa que o corpo da requisicao vai ser o animalDto
        log.info("Atualizando animal por id");
        Animal found = service.findAnimal(id);  //encontrar animal por id

        if (isNull(found)) {  //se animal nao existir retorna not found
            return ResponseEntity.notFound().build(); //retorna not found
        }

        Animal updated = service.update(id, animalDto.getName(), animalDto.getAge(), animalDto.getColor()); //

        return ResponseEntity.ok(updated);
    }
}