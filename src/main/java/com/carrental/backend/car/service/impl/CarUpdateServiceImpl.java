package com.carrental.backend.car.service.impl;

import com.carrental.backend.car.domain.Car;
import com.carrental.backend.car.dto.CarUpdateDto;
import com.carrental.backend.car.mapper.CarMapper;
import com.carrental.backend.car.repository.CarRepository;
import com.carrental.backend.car.service.CarUpdateService;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarUpdateServiceImpl implements CarUpdateService {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public CarUpdateDto execute(CarUpdateDto carUpdateDto) {
    if(Objects.nonNull(carUpdateDto.getId())) {
      Car car = getCar(carUpdateDto);
      remapCarUpdateDtoToCar(car,carUpdateDto);
      carRepository.save(car);
      return carMapper.carToCarUpdateDto(car);
    }
    throw new NoSuchElementException("No element");
  }

  private void remapCarUpdateDtoToCar(Car car, CarUpdateDto carUpdateDto) {
    carMapper.carUpdateDtoToCar(carUpdateDto, car);
    car.setUpdateDate(new Date());
  }

  private Car getCar(CarUpdateDto carUpdateDto) {
    Optional<Car> carOptional = carRepository.findById(carUpdateDto.getId());
    return carOptional.orElseThrow(NoSuchElementException::new);
  }
}
