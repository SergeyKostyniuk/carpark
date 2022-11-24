package com.carpark.infopolus.dto;

import java.util.Objects;

public class CarDto {
  private long id;
  private String brand;

  public CarDto() {
  }

  public CarDto(long id, String brand) {
    this.id = id;
    this.brand = brand;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarDto carDto)) {
      return false;
    }
    return getId() == carDto.getId() && Objects.equals(getBrand(), carDto.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBrand());
  }

  @Override
  public String toString() {
    return "CarDto{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        '}';
  }
}
