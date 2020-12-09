package com.carrental.backend.car.dto;

import com.carrental.backend.borrows.domain.Borrows;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarBaseDto {

  private String brand;
  private double engineCapacity;
  private Set<Borrows> borrows;



}
