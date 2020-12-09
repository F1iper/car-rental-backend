package com.carrental.backend.car.mapper.impl;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.dto.CarCreateDto;
import com.carrental.backend.car.dto.CarUpdateDto;
import com.carrental.backend.car.mapper.BaseMapper;
import com.carrental.backend.car.mapper.CarMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl extends BaseMapper implements CarMapper {

  @Override
  public Car carCreateDtoToCar(CarCreateDto carCreateDto) {
    return remapObject(carCreateDto, new Car());
  }

  @Override
  public CarCreateDto carToCarCreateDto(Car car) {
    return remapObject(car, new CarCreateDto());
  }

  @Override
  public void carUpdateDtoToCar(CarUpdateDto carUpdateDto, Car car) {
    remapObject(carUpdateDto, car);
  }

  @Override
  public CarUpdateDto carToCarUpdateDto(Car car) {
    return remapObject(car, new CarUpdateDto());
  }
}
