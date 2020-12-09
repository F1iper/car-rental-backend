package com.carrental.backend.car.service.impl;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.dto.CarCreateDto;
import com.carrental.backend.car.mapper.CarMapper;
import com.carrental.backend.car.repository.CarRepository;
import com.carrental.backend.car.service.CarCreateService;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarCreateServiceImpl implements CarCreateService {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  @Override
  public CarCreateDto save(CarCreateDto carCreateDto) {
    Car car = prepareCar(carCreateDto);
    Car save = carRepository.save(car);
    return carMapper.carToCarCreateDto(save);
  }

  private Car prepareCar(CarCreateDto carCreateDto) {
    Car car = carMapper.carCreateDtoToCar(carCreateDto);
    car.setCreateDate(new Date());
    return car;
  }

}
