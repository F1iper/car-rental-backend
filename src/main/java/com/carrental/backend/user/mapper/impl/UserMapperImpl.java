package com.carrental.backend.user.mapper.impl;

import com.carrental.backend.car.mapper.BaseMapper;
import com.carrental.backend.user.domain.User;
import com.carrental.backend.user.dto.UserDto;
import com.carrental.backend.user.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl extends BaseMapper implements UserMapper {

  @Override
  public User userDtoToUser(UserDto userDto) {
    return remapObject(userDto, new User());
  }

  @Override
  public UserDto userToUserDto(User user) {
    return remapObject(user, new UserDto());
  }

  @Override
  public List<UserDto> mapPageUserToListUserDto(Page<User> listUser) {
    List<UserDto> result = new ArrayList<>();
    for (User user : listUser.getContent()) {
      result.add(userToUserDto(user));
    }
    return result;
  }
}
