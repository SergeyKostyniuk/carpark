package com.carpark.infopolus.repository;

import com.carpark.infopolus.model.PersonModel;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
  private static Map<Long, PersonModel> people;

  {
    people = Map.of(
        1L, new PersonModel(1, "Petrov"),
        2L, new PersonModel(2, "Ivanov"),
        3L, new PersonModel(3, "Sidorov")
    );
  }

  public Optional<PersonModel> findById(final long id) {
    return Optional.ofNullable(people.get(id));
  }

  public Stream<PersonModel> findAll() {
    return people.values()
        .stream()
        .sorted(Comparator.comparing(PersonModel::getId));
  }
}
