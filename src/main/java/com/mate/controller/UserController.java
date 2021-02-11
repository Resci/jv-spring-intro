package com.mate.controller;

import com.mate.dto.UserResponseDto;
import com.mate.model.User;
import com.mate.service.UserMapper;
import com.mate.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User firstUser = new User();
        firstUser.setName("Bob");
        firstUser.setLastName("Robson");
        userService.add(firstUser);
        User secondUser = new User();
        secondUser.setName("Alice");
        secondUser.setLastName("Alyson");
        userService.add(secondUser);
        return "injected";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return userMapper.mapToDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
