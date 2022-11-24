package com.carpark.infopolus.exception.handler;

import com.carpark.infopolus.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class PersonExceptionHandlerTest {

  @InjectMocks
  private PersonExceptionHandler exceptionHandler;

  @Test
  void handleNotFound() {
    final var errorMessage = "test";
    final var expected = new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    final var actual = exceptionHandler.handleNotFound(new NotFoundException(errorMessage));

    assertEquals(expected, actual);
  }
}
