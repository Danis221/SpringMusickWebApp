package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.dto.UserDto;
import ru.itis.mv.service.UserService;

import static ru.itis.mv.dto.UserDto.fromEntity;

@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user/profile")
    public UserDto userProfile() {
        return fromEntity(userService.getCurrentUser());
    }
}
