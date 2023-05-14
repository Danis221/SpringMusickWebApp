package ru.itis.mv.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.mv.service.AuthService;

@RestController
@RequestMapping("api/logout")
@RequiredArgsConstructor
public class LogOutController {

    private final AuthService authService;

    @PostMapping()
    public ResponseEntity<String> logoutUser(@RequestHeader("Authorization") String tokenHeader) {

        String token = authService.logoutUser(tokenHeader);

        return ResponseEntity.ok("Logged out successfully, token:" + token);
    }
}
