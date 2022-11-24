package com.carpark.infopolus.exception.handler;

import com.carpark.infopolus.controller.PersonController;
import com.carpark.infopolus.exception.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = PersonController.class)
public class PersonExceptionHandler {

  private static Logger log = LoggerFactory.getLogger(PersonExceptionHandler.class);

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFound(final NotFoundException e) {
    log.error("Model not found exception {}", e.getMessage());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }
}
