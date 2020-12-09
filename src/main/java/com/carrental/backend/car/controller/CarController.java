package com.carrental.backend.car.controller;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.dto.CarCreateDto;
import com.carrental.backend.car.dto.CarUpdateDto;
import com.carrental.backend.car.repository.CarRepository;
import com.carrental.backend.car.service.CarCreateService;
import com.carrental.backend.car.service.CarDeleteService;
import com.carrental.backend.car.service.CarUpdateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

  private final CarRepository carRepository;
  private final CarCreateService carCreateService;
  private final CarUpdateService carUpdateService;
  private final CarDeleteService carDeleteService;

  @GetMapping
  public List<Car> listCars() {
    return carRepository.findAll();
  }
  @PostMapping
  public CarCreateDto createCar(@RequestBody CarCreateDto carCreateDto) {
    return carCreateService.save(carCreateDto);
  }

  @PutMapping
  public CarUpdateDto updateCar(@RequestBody CarUpdateDto carUpdateDto) {
    return carUpdateService.execute(carUpdateDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteCar(@PathVariable Long id) {
    return carDeleteService.execute(id);
  }
}
