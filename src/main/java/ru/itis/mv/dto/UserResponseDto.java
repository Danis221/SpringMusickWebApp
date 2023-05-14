package ru.itis.mv.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.mv.model.User;

@Data
@Builder
public class UserResponseDto {

    private Integer id;

    private String name;

    private String email;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getFirstName())
                .email(user.getEmail())
                .build();
    }
}
