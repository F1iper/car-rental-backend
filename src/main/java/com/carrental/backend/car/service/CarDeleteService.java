package com.carrental.backend.car.service;

import com.carrental.backend.car.domain.Car;
import org.springframework.http.ResponseEntity;

public interface CarDeleteService {

  ResponseEntity<?> execute(Long id);

  void deleteCar(Car car);

}
