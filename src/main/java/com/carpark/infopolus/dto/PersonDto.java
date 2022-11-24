package com.carpark.infopolus.dto;

import java.util.List;
import java.util.Objects;

public class PersonDto {
  private long id;
  private String name;
  private List<CarDto> cars;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CarDto> getCars() {
    return cars;
  }

  public void setCars(List<CarDto> cars) {
    this.cars = cars;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersonDto personDto)) {
      return false;
    }
    return getId() == personDto.getId() && Objects.equals(getName(), personDto.getName()) &&
        Objects.equals(getCars(), personDto.getCars());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getCars());
  }

  @Override
  public String toString() {
    return "PersonDto{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cars=" + cars +
        '}';
  }
}
