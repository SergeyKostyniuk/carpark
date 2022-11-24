package com.carpark.infopolus.model;

import java.util.Objects;

public class CarModel {
  private long id;
  private String brand;
  private long ownerId;

  public CarModel(long id, String brand, long ownerId) {
    this.id = id;
    this.brand = brand;
    this.ownerId = ownerId;
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

  public long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarModel carModel)) {
      return false;
    }
    return getId() == carModel.getId() && getOwnerId() == carModel.getOwnerId() &&
        Objects.equals(getBrand(), carModel.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBrand(), getOwnerId());
  }

  @Override
  public String toString() {
    return "CarModel{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        ", ownerId=" + ownerId +
        '}';
  }
}
