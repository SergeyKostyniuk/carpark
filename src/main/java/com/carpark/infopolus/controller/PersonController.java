package com.carpark.infopolus.controller;

import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("people")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("{id}")
  public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") long id) {
    return ResponseEntity.ok(personService.getById(id));
  }

  @GetMapping
  public ResponseEntity<List<PersonDto>> getAllPeople() {
    return ResponseEntity.ok(personService.getAll());
  }
}
