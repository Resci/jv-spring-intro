package com.mate.service;

import com.mate.dto.UserResponseDto;
import com.mate.model.User;

public class UserMapper {
    public static User toObj(UserResponseDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        return user;
    }

    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
