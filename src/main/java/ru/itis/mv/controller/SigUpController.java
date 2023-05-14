package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.mv.dto.CreateUserRequestDto;
import ru.itis.mv.dto.UserResponseDto;
import ru.itis.mv.service.UserService;

@RestController
@RequestMapping("/api/sig_up")
@RequiredArgsConstructor
public class SigUpController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> signUp(@RequestBody CreateUserRequestDto newUser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(newUser));
    }
}
