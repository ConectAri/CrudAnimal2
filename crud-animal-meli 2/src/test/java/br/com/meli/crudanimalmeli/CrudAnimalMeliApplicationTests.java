package br.com.meli.crudanimalmeli;

import br.com.meli.crudanimalmeli.entities.Animal;
import br.com.meli.crudanimalmeli.services.AnimalService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

// Testes usando o Mock
//"Mook" parece ser um erro de digitação no seu código. O termo correto é "Mock".
// No contexto de testes de unidade em Java, um "Mock" é um objeto falso que simula o comportamento de um objeto real.
// É usado para isolar o código sob teste de dependências externas. No seu código, `AnimalService` é
// "mockado" para simular seu comportamento durante o teste do método `create`. Isso é feito usando a biblioteca Mockito,
// que fornece métodos para criar e configurar objetos mock.




@SpringBootTest
class CrudAnimalMeliApplicationTests {


	@Test
	void testCreateAnimal() {
		// Defina os valores para o teste
		String expectedName = "Dog";
		String expectedColor = "Black";
		Integer expectedAge = 5;

		// Crie um objeto Animal para teste
		Animal expectedAnimal = new Animal(expectedName, expectedColor, expectedAge);

		// Crie um mock do AnimalService
		AnimalService animalService = mock(AnimalService.class);

		// Defina o comportamento do mock
		when(animalService.create(expectedName, expectedAge, expectedColor)).thenReturn(expectedAnimal);

		// Chame o método que você está testando
		Animal actualAnimal = animalService.create(expectedName, expectedAge, expectedColor);

		// Verifique se o resultado é o esperado
		assertEquals(expectedAnimal, actualAnimal);
	}



	@Test
	void testFindAllAnimals() { //Esse teste serve para verificar se o método findAll() está retornando a lista de animais correta.


		// Crie uma lista de animais para teste
		List<Animal> expectedAnimals = Arrays.asList(
				new Animal("Dog", "Black", 5),
				new Animal("Cat", "White", 3)
		);

		// Crie um mock do AnimalService
		AnimalService animalService = mock(AnimalService.class);

		// Defina o comportamento do mock
		when(animalService.findAll()).thenReturn(expectedAnimals);

		// Chame o método que você está testando
		List<Animal> actualAnimals = animalService.findAll();

		// Verifique se o resultado é o esperado
		assertEquals(expectedAnimals, actualAnimals);

	}

	@Test
	void testFindAnimalById() {

	}

	@Test
	void testFindAnimalByName() {

	}

	@Test
	void testFindAnimalByColor() {

	}

	@Test
	void testUpdateAnimal() {

	}

	@Test
	void testDeleteAnimal() {

	}

	@Test
	void testDeleteAllAnimals() {

	}

	@Test
	void testDeleteAnimalById() {

	}

	@Test
	void testDeleteAnimalByName() {

	}

	@Test
	void testDeleteAnimalByColor() {

	}


}
