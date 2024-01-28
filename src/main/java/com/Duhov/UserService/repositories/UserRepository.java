package com.Duhov.UserService.repositories;

import com.Duhov.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUsersByCityId(Integer cityId);

    List<User> getUsersByCityName(String cityName);

    Optional<User> getUserByEmail(String email);
}