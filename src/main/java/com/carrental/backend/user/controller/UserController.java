package com.carrental.backend.user.controller;

import com.carrental.backend.user.domain.User;
import com.carrental.backend.user.dto.UserDto;
import com.carrental.backend.user.repository.UserRepository;
import com.carrental.backend.user.service.UserCreateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

  private final UserRepository userRepository;
  private final UserCreateService userCreateService;

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto) {
    return userCreateService.execute(userDto);
  }

  @GetMapping
  public List<User> listUser() {
    return userRepository.findAll();
  }
}
