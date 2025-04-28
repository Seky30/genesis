package com.projekt.genesis.Service;

import com.projekt.genesis.Dto.UserDetailDto;
import com.projekt.genesis.Repository.UserRepository;
import com.projekt.genesis.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final PersonIdValidator personIdValidator;

    @Autowired
    public UserServiceImplement(UserRepository userRepository, PersonIdValidator personIdValidator) {
        this.userRepository = userRepository;
        this.personIdValidator = personIdValidator;
    }

    @Override
    public User createUser(UserDetailDto userDetailDto) {
        personIdValidator.validatePersonId(userDetailDto.getPersonId());
        Optional<User> existingUser = userRepository.findByPersonId(userDetailDto.getPersonId());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Chyba: Uživatel s personId " + userDetailDto.getPersonId() + " již existuje");
        }

        User user = new User();
        user.setName(userDetailDto.getName());
        user.setSurname(userDetailDto.getSurname());
        user.setPersonId(userDetailDto.getPersonId());

        user.setUuid(UUID.randomUUID().toString());

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> result = userRepository.findById(id);
        User theUserDetail = null;
        if (result.isPresent()) {
            theUserDetail = result.get();
        } else {
            throw new RuntimeException("Nelze najít zadané ID" + id);
        }
        return theUserDetail;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UserDetailDto userDetailDto) {
        if(userDetailDto.getPersonId()!= null && !userDetailDto.getPersonId().isEmpty()) {
            throw new RuntimeException("PersonId nesmí být změněno");
        }
        User user = getUserById(userDetailDto.getId());
        user.setName(userDetailDto.getName());
        user.setSurname(userDetailDto.getSurname());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetailDto getUserDetail(Long id) {
        User user = getUserById(id);
        return new UserDetailDto(user);
    }

    @Override
    public List<UserDetailDto> getAllUserDetails() {
        return userRepository.findAll().stream()
                .map(UserDetailDto::new)
                .collect(Collectors.toList());
    }
}
