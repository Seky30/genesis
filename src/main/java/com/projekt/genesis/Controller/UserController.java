package com.projekt.genesis.Controller;

import com.projekt.genesis.Dto.UserDetailDto;
import com.projekt.genesis.Dto.UserDto;
import com.projekt.genesis.Service.UserService;
import com.projekt.genesis.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
        User user = userService.createUser(userDto);
        return new ResponseEntity<>(convertForCreateUser(user), HttpStatus.CREATED);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    private UserDto convertForCreateUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false, defaultValue = "false") boolean detail) {
        if (detail) {
            List<UserDetailDto> users = userService.getAllUserDetails();
            return ResponseEntity.ok(users);
        } else {
            List<User> users = userService.getAllUsers();
            List<UserDto> userDtos = users.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userDtos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id,
                                         @RequestParam(required = false, defaultValue = "false") boolean detail) {

        if (detail) {
            UserDetailDto userDetailDto = userService.getUserDetail(id);
            return ResponseEntity.ok(userDetailDto);
        } else {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(convertToDto(user));
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto) {

        User updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(convertToDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Uživatel smazán s id - " + id);
    }
}

