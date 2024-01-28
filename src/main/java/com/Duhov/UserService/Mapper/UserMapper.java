package com.Duhov.UserService.Mapper;

import com.Duhov.UserService.Exceptions.CityNotFoundException;
import com.Duhov.UserService.dto.UserDTO;
import com.Duhov.UserService.entities.City;
import com.Duhov.UserService.entities.User;
import com.Duhov.UserService.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private CityService cityService;

    public UserDTO toDTO(User user) {

        String attachmentId = null;
        String city = null;

        //if (user.getAttachment() != null) attachmentId = user.getAttachment().getId();

        if (user.getCity() != null) {
            city = user.getCity().getName();
        }

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                //.role(user.getUserRole())
                .balance(user.getBalance())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .accountStatus(user.getAccountStatus())
                .cityName(city)
                .completedProjects(user.getCompletedProjects())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.getGender())
                .registrationDate(user.getRegistrationDate())
                .skillsDescription(user.getSkillsDescription())
                //.currentRating(user.getCurrentRating())
                .attachmentId(attachmentId)
                //.projects(user.getProjects())
                .build();
    }

    public User toUser(UserDTO userDTO) throws CityNotFoundException/*, AttachmentNotFoundException*/ {

        City city = null;
        //Attachment attachment = null;

        if (userDTO.getCityName() != null) {
            city = cityService.getCityByName(userDTO.getCityName());
        }

//        if (userDTO.getAttachmentId() != null) {
//            attachment = attachmentService.getAttachment(userDTO.getAttachmentId());
//        }

        return User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                //.userRole(userDTO.getRole())
                .balance(userDTO.getBalance())
                .firstName(userDTO.getFirstName())
                .surname(userDTO.getSurname())
                .accountStatus(userDTO.getAccountStatus())
                .city(city)
                .completedProjects(userDTO.getCompletedProjects())
                .dateOfBirth(userDTO.getDateOfBirth())
                .gender(userDTO.getGender())
                .registrationDate(userDTO.getRegistrationDate())
                .skillsDescription(userDTO.getSkillsDescription())
                //.attachment(attachment)
                //.currentRating(userDTO.getCurrentRating())
                //.projects(userDTO.getProjects())
                .build();
    }

}
