package com.carpark.infopolus.repository;

import com.carpark.infopolus.model.CarModel;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

  private static Map<Long, CarModel> cars;

  {
    cars = Map.of(
        1L, new CarModel(1, "VAZ", 1),
        2L, new CarModel(2, "Honda", 2),
        3L, new CarModel(3, "Volvo", 1),
        4L, new CarModel(4, "BMW", 1),
        5L, new CarModel(5, "Audi", 3),
        6L, new CarModel(6, "Toyota", 2),
        7L, new CarModel(7, "Mercedes", 1)
    );
  }

  public List<CarModel> getCarsByOwnerId(final long ownerId) {
    return cars.values()
        .stream()
        .filter(car -> car.getOwnerId() == ownerId)
        .sorted(Comparator.comparing(CarModel::getId))
        .toList();
  }
}
