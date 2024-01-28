package com.Duhov.UserService.dto;

import com.Duhov.UserService.entities.AccountStatus;
import com.Duhov.UserService.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String surname;
    private String email;
    private String password;
    private Double balance;
    private LocalDate dateOfBirth;
    private String skillsDescription;
    private Integer completedProjects;
    private AccountStatus accountStatus;
    private Gender gender;
    private LocalDateTime registrationDate;
    private String cityName;
    private String attachmentId;
    private Integer currentRating;
//    private List<Project> projects;
}
