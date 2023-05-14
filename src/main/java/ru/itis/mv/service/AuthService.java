package ru.itis.mv.service;

import lombok.NonNull;
import ru.itis.mv.dto.JwtRequest;
import ru.itis.mv.dto.JwtResponse;
import ru.itis.mv.filter.JwtAuthentication;

import javax.security.auth.message.AuthException;

public interface AuthService {

    JwtResponse login(JwtRequest authRequest) throws AuthException;

    JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException;

    JwtResponse refresh(@NonNull String refreshToken) throws AuthException;

    String logoutUser(String token);

    JwtAuthentication getAuthInfo();
}
