package com.carrental.backend.user.service;

import com.carrental.backend.user.dto.UserDto;

public interface UserCreateService {

  UserDto execute(UserDto userDto);
}
