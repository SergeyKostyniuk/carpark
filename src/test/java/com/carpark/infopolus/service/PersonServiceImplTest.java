package com.carpark.infopolus.service;

import com.carpark.infopolus.dto.CarDto;
import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.exception.NotFoundException;
import com.carpark.infopolus.mapper.PersonMapper;
import com.carpark.infopolus.model.CarModel;
import com.carpark.infopolus.model.PersonModel;
import com.carpark.infopolus.repository.CarRepository;
import com.carpark.infopolus.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PersonServiceImplTest {

  @InjectMocks
  private PersonServiceImpl personService;
  @Mock
  private PersonRepository personRepository;
  @Mock
  private CarRepository carRepository;
  @Mock
  private PersonMapper personMapper;


  @Test
  void getById() {
    final var personId = 1L;
    final var expected = new PersonDto();
    expected.setId(1);
    expected.setName("Serhii");
    expected.setCars(List.of(new CarDto(1, "Audi")));
    final var personModel = new PersonModel(1, "Serhii");
    final var carModels = List.of(new CarModel(1, "Audi", 1));

    when(personRepository.findById(anyLong())).thenReturn(Optional.of(personModel));
    when(carRepository.getCarsByOwnerId(anyLong())).thenReturn(carModels);
    when(personMapper.mapPersonModelToPersonDto(any(), anyList())).thenReturn(expected);

    final var actual = personService.getById(personId);

    assertEquals(expected, actual);

    verify(personRepository).findById(personId);
    verify(carRepository).getCarsByOwnerId(personId);
    verify(personMapper).mapPersonModelToPersonDto(personModel, carModels);
    verifyNoMoreInteractions(personRepository, carRepository, personMapper);
  }

  @Test
  void getByIdThrowNotFoundException() {
    final var personId = 1L;

    when(personRepository.findById(anyLong())).thenReturn(Optional.empty());

    final var exception = assertThrows(NotFoundException.class, () -> personService.getById(personId));

    assertEquals("Person does not exist", exception.getMessage());

    verify(personRepository).findById(personId);
    verifyNoMoreInteractions(personRepository);
    verifyNoInteractions(carRepository, personMapper);
  }

  @Test
  void getAll() {
    final var personId = 1L;
    final var person = new PersonDto();
    person.setId(1);
    person.setName("Serhii");
    person.setCars(List.of(new CarDto(1, "Audi")));
    final var expected = List.of(person);
    final var personModel = new PersonModel(1, "Serhii");
    final var carModels = List.of(new CarModel(1, "Audi", 1));

    when(personRepository.findAll()).thenReturn(Stream.of(personModel));
    when(carRepository.getCarsByOwnerId(anyLong())).thenReturn(carModels);
    when(personMapper.mapPersonModelToPersonDto(any(), anyList())).thenReturn(person);

    final var actual = personService.getAll();

    assertEquals(expected, actual);

    verify(personRepository).findAll();
    verify(carRepository).getCarsByOwnerId(personId);
    verify(personMapper).mapPersonModelToPersonDto(personModel, carModels);
    verifyNoMoreInteractions(personRepository, carRepository, personMapper);
  }
}
