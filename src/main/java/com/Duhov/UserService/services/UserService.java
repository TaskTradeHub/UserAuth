package com.Duhov.UserService.services;

import com.Duhov.UserService.Exceptions.CityNotFoundException;
import com.Duhov.UserService.Exceptions.UserNotFoundException;
import com.Duhov.UserService.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO addUserProjects(Long userId, Long projectId) throws Exception;

    UserDTO deleteUserProjects(Long userId, Long projectId) throws Exception;

    UserDTO getUserById(Long id) throws UserNotFoundException;

    UserDTO getUserByEmail(String email) throws UserNotFoundException;

    UserDTO updateUserById(Long id, UserDTO userDTO) throws UserNotFoundException, CityNotFoundException;

    String deleteUserById(Long id) throws UserNotFoundException;

    UserDTO changeUserPhoto(Long userId, MultipartFile photo) throws Exception;

    List<UserDTO> getUsersByCityName(String city);

    List<UserDTO> getUsersByCityId(Integer cityId);

    UserDTO createUser(UserDTO userDTO) throws CityNotFoundException;
}
