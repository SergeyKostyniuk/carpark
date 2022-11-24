package com.carpark.infopolus.controller;

import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.service.PersonService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PersonControllerTest {

  @InjectMocks
  private PersonController personController;
  @Mock
  private PersonService personService;

  @Test
  public void getPersonByIdSuccessfully() {
    final var personId = 1L;
    final var person = new PersonDto();
    person.setId(personId);
    person.setName("Test");
    final var expected = ResponseEntity.ok(person);

    when(personService.getById(anyLong())).thenReturn(person);

    final var actual = personController.getPersonById(personId);

    assertEquals(expected, actual);

    verify(personService).getById(personId);

    verifyNoMoreInteractions(personService);
  }

  @Test
  public void getAllPeopleSuccessfully() {
    final var personId = 1L;
    final var person = new PersonDto();
    person.setId(personId);
    person.setName("Test");
    final var expected = ResponseEntity.ok(List.of(person));

    when(personService.getAll()).thenReturn(List.of(person));

    final var actual = personController.getAllPeople();

    assertEquals(expected, actual);

    verify(personService).getAll();

    verifyNoMoreInteractions(personService);
  }
}
