package ru.itis.mv.service;

import ru.itis.mv.dto.CreateUserRequestDto;
import ru.itis.mv.dto.UserDto;
import ru.itis.mv.dto.UserResponseDto;
import ru.itis.mv.model.User;

public interface UserService {
    UserDto getUserById(Integer id);

    UserDto getUserByEmail(String email);

    User getCurrentUser();
    UserResponseDto create(CreateUserRequestDto createUserDto);
}
