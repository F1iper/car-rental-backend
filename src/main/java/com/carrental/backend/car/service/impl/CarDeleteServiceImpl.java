package com.carrental.backend.car.service.impl;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.repository.CarRepository;
import com.carrental.backend.car.service.CarDeleteService;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarDeleteServiceImpl implements CarDeleteService {

  private final CarRepository carRepository;

  public ResponseEntity<?> execute(Long id) {
    Optional<Car> optionalCar = carRepository.findById(id);
    if(optionalCar.isPresent()){
      Car car = optionalCar.get();
      deleteCar(car);
      return ResponseEntity.ok(true);
    }
    throw new NoSuchElementException("Car with id: "  + id + " not found.");
  }

  public void deleteCar(Car car) {
    car.setDeleteDate(new Date());
    carRepository.save(car);
  }

}
