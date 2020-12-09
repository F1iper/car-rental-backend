package com.carrental.backend.user.mapper;

import com.carrental.backend.user.domain.User;
import com.carrental.backend.user.dto.UserDto;
import java.util.List;
import org.springframework.data.domain.Page;

public interface UserMapper {

  User userDtoToUser(UserDto userDto);

  UserDto userToUserDto(User user);

  List<UserDto> mapPageUserToListUserDto(Page<User> listUser);
}
