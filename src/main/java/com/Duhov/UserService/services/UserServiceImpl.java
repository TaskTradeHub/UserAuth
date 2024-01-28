package com.Duhov.UserService.services;

import com.Duhov.UserService.Exceptions.CityNotFoundException;
import com.Duhov.UserService.Exceptions.UserNotFoundException;
import com.Duhov.UserService.Mapper.UserMapper;
import com.Duhov.UserService.dto.UserDTO;
import com.Duhov.UserService.entities.User;
import com.Duhov.UserService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO).toList();
    }

    @Override
    public UserDTO addUserProjects(Long userId, Long projectId) throws Exception {
        return null;
    }

    @Override
    public UserDTO deleteUserProjects(Long userId, Long projectId) throws Exception {
        return null;
    }

    @Override
    public UserDTO getUserById(Long userId) throws UserNotFoundException {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("There is no user with id: " + userId)
        );

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) throws UserNotFoundException {

        User user = userRepository.getUserByEmail(email).orElseThrow(
                () -> new UserNotFoundException("There is no user with email: " + email)
        );

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) throws UserNotFoundException, CityNotFoundException {
        return null;
    }

    @Override
    public String deleteUserById(Long userId) throws UserNotFoundException {

        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("There is no user with id: " + userId);
        }

        userRepository.deleteById(userId);

        return "successful deleted";

    }

    @Override
    public UserDTO changeUserPhoto(Long userId, MultipartFile photo) throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getUsersByCityName(String city) {
        return userRepository.getUsersByCityName(city).stream()
                .map(userMapper::toDTO).toList();
    }

    @Override
    public List<UserDTO> getUsersByCityId(Integer cityId) {
        return userRepository.getUsersByCityId(cityId).stream()
                .map(userMapper::toDTO).toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws CityNotFoundException {

        userRepository.save(userMapper.toUser(userDTO));

        return userDTO;
    }

}