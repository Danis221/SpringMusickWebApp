package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String fullName;

    private String email;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .fullName(user.getFirstName() + user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public static UserDto fromEntity(CreateUserRequestDto user) {
        return UserDto.builder()
                .fullName(user.getName())
                .email(user.getEmail())
                .build();
    }
}
