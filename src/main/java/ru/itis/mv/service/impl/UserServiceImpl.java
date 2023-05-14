package ru.itis.mv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.itis.mv.dto.CreateUserRequestDto;
import ru.itis.mv.dto.UserDto;
import ru.itis.mv.dto.UserResponseDto;
import ru.itis.mv.model.User;
import ru.itis.mv.repository.UserRepository;
import ru.itis.mv.service.UserService;

import static ru.itis.mv.dto.UserDto.fromEntity;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDto getUserById(Integer id) {
        return fromEntity(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id" + id + "not found")));
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return fromEntity(userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email" + email + "not found")));
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();

        User currentUser = (userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with emai" + email + "not found")));

        return currentUser;
    }

    @Override
    public UserResponseDto create(CreateUserRequestDto createUserDto) {
        String encodedPassword = encoder.encode(createUserDto.getPassword());
        User user = User.builder()
                .firstName(createUserDto.getName())
                .email(createUserDto.getEmail())
                .password(encodedPassword)
                .build();

        userRepository.save(user);

        return UserResponseDto.fromEntity(user);
    }
}
