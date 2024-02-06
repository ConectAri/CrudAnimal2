package br.com.meli.crudanimalmeli.services;

import br.com.meli.crudanimalmeli.entities.Animal;
import br.com.meli.crudanimalmeli.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j  //Significa que vai ter um log
@Service //Significa que é um service
@RequiredArgsConstructor //Significa que vai ter um construtor
public class AnimalServiceImpl implements AnimalService {

    //implements significa que é uma interface e ela vai ter os métodos que estão na interface

    private final AnimalRepository repository; //repository é um objeto que vai ter acesso ao banco de dados

    @Override  //Significa que é um método e vai sobescrever
    public Animal create(String name, Integer age, String color) {
        Animal animal = new Animal();

        if (name != null){
            animal.setName(name.toLowerCase()); //toLowerCase  é
        }
        animal.setAge(age);
        animal.setColor(color);

        return repository.save(animal);
    }

    @Override //Significa que é um método
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
    repository.deleteById(id);
    }

    @Override //Método para atualizar
    public Animal update(Integer id, String name, Integer age, String color) {
        //Encontrar o animal no banco de dados
        //Vou atualizar o nome, idade e cor do animal
        //Salvar o animal novamente
        Optional<Animal> foundAnimal = repository.findById(id); //foundAnimal tem relacao com banco de dados
        if (foundAnimal.isPresent()){ //Mesmo que ele é diferente de null  !== null
            Animal animalEncontradoParaAtualizar = foundAnimal.get();//Atualizar o animal
            animalEncontradoParaAtualizar.setName(name);//Utilizando o set para atualizar o nome
            animalEncontradoParaAtualizar.setAge(age); //set atribui um valor a uma variavel
            animalEncontradoParaAtualizar.setColor(color);
            return repository.save(animalEncontradoParaAtualizar);
        }
        return null; //Caso nao encontre o animal o retorno é null
    }

    @Override //Metodo para encontrar animal por id
    public Animal findAnimal(Integer id) {
        Optional<Animal> foundAnimal = repository.findById(id);
        return foundAnimal.orElse(null);

    }

    @Override
    public Animal findAnimalByName(String name) {
        Optional<Animal> foundAnimal = repository.findByName(name.toLowerCase());
        return foundAnimal.orElse(null);
    }

    @Override
    public List<Animal> findAnimalByColor(String color) {
        return repository.findByColor(color.toLowerCase());
    }

    @Override //Metodo para encontrar animal por idade
    public List<Animal> findAllByAge(Integer age) {

        return null;
    }

}
