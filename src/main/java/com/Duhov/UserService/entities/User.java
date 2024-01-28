package com.Duhov.UserService.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "balance",
            nullable = false
    )
    private Double balance;

    @Column(
            name = "dateOfBirth",
            nullable = false
    )
    private LocalDate dateOfBirth;

    @Column(
            name = "skillsDescription"
    )
    private String skillsDescription;

    @Column(
            name = "completedProjects"
    )
    private Integer completedProjects;

    @Column(
            name = "accountStatus"
    )
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Column(
            name = "gender"
    )
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "registrationDate")
    private LocalDateTime registrationDate;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

//    private Attachment attachment;

    //    private Rating currentRating;
    //    private List<Project> projects;

    @PrePersist
    public void setDefaultStatus() {
        if (this.accountStatus == null) {
            this.accountStatus = AccountStatus.FREE; // установка дефолтного значения
        }

        if (this.registrationDate == null) {
            this.registrationDate = LocalDateTime.now(ZoneId.of("Europe/Saratov")); // установка дефолтного значения
        }

        if (this.balance == null) {
            this.balance = 0.0; // установка дефолтного значения
        }

        if (this.completedProjects == null) {
            this.completedProjects = 0; // установка дефолтного значения
        }
    }

}
