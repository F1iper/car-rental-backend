package com.carrental.backend.user.service.impl;

import com.carrental.backend.user.domain.User;
import com.carrental.backend.user.dto.UserDto;
import com.carrental.backend.user.mapper.UserMapper;
import com.carrental.backend.user.repository.UserRepository;
import com.carrental.backend.user.service.UserCreateService;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateServiceImpl implements UserCreateService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserDto execute(UserDto userDto) {
    modifyUserDtoData(userDto);
    User savedUser = save(userDto);
    return userMapper.userToUserDto(savedUser);
  }

  private void modifyUserDtoData(UserDto userDto) {
    userDto.setCreatedAt(new Date());
  }

  private User save(UserDto userDto) {
    return userRepository.save(userMapper.userDtoToUser(userDto));
  }
}
