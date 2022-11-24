package com.carpark.infopolus.service;

import com.carpark.infopolus.dto.PersonDto;
import java.util.List;

public interface PersonService {
  PersonDto getById(long id);

  List<PersonDto> getAll();
}
