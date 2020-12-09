package com.carrental.backend.car.mapper;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.dto.CarCreateDto;
import com.carrental.backend.car.dto.CarUpdateDto;

public interface CarMapper {

  Car carCreateDtoToCar(CarCreateDto carCreateDto);

  CarCreateDto carToCarCreateDto(Car car);

  void carUpdateDtoToCar(CarUpdateDto carUpdateDto, Car car);

  CarUpdateDto carToCarUpdateDto(Car car);




}
