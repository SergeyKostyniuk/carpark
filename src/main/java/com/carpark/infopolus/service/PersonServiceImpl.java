package com.carpark.infopolus.service;

import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.exception.NotFoundException;
import com.carpark.infopolus.mapper.PersonMapper;
import com.carpark.infopolus.repository.CarRepository;
import com.carpark.infopolus.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final CarRepository carRepository;
  private final PersonMapper personMapper;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository, CarRepository carRepository, PersonMapper personMapper) {
    this.personRepository = personRepository;
    this.carRepository = carRepository;
    this.personMapper = personMapper;
  }

  @Override
  public PersonDto getById(final long id) {
    final var person = personRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Person does not exist"));
    final var cars = carRepository.getCarsByOwnerId(id);

    return personMapper.mapPersonModelToPersonDto(person, cars);
  }

  @Override
  public List<PersonDto> getAll() {
    return personRepository.findAll().map(person -> personMapper.mapPersonModelToPersonDto(person, carRepository.getCarsByOwnerId(
        person.getId()))).toList();
  }
}
