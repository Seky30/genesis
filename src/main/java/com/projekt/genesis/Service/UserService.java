package com.projekt.genesis.Service;

import com.projekt.genesis.Dto.UserDetailDto;
import com.projekt.genesis.Dto.UserDto;
import com.projekt.genesis.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserDetailDto userDetailDto);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(UserDetailDto userDetailDto);

    void deleteUser(Long id);

    UserDetailDto getUserDetail(Long id);

    List<UserDetailDto> getAllUserDetails();
}
