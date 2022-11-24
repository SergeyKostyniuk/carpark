package com.carpark.infopolus.controller;

import com.carpark.infopolus.AbstractSystemTest;
import com.carpark.infopolus.dto.CarDto;
import com.carpark.infopolus.dto.PersonDto;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonControllerSystemTest extends AbstractSystemTest {

  @Test
  public void launchGameTest() throws Exception {
    final var personId = 1L;
    final var expected = new PersonDto();
    expected.setId(personId);
    expected.setName("Petrov");
    expected.setCars(List.of(
        new CarDto(1, "VAZ"),
        new CarDto(3, "Volvo"),
        new CarDto(4, "BMW"),
        new CarDto(7, "Mercedes"))
    );

    final var mvcResult =
        mockMvc.perform(get(String.format("http://localhost:%s/people/%d", port, personId))).andExpect(status().isOk())
            .andReturn();

    final var actual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PersonDto.class);

    assertEquals(expected, actual);
  }
}
