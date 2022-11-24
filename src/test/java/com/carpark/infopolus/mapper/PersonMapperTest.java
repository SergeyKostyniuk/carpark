package com.carpark.infopolus.mapper;

import com.carpark.infopolus.dto.CarDto;
import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.model.CarModel;
import com.carpark.infopolus.model.PersonModel;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({SpringExtension.class})
class PersonMapperTest {

  private static PersonMapper personMapper;

  @BeforeAll
  public static void setup() {
    personMapper = PersonMapper.INSTANCE;
  }

  @Test
  public void mapPersonModelToPersonDto() {
    final var expected = new PersonDto();
    expected.setId(1);
    expected.setName("Serhii");
    expected.setCars(List.of(new CarDto(1, "Audi")));
    final var personModel = new PersonModel(1, "Serhii");
    final var carModels = List.of(new CarModel(1, "Audi", 1));

    final var actual = personMapper.mapPersonModelToPersonDto(personModel, carModels);

    assertNotNull(actual);
    assertEquals(expected, actual);
  }
}
