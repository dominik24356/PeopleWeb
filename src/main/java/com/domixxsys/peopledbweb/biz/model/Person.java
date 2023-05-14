package com.domixxsys.peopledbweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "first name can not be empty !")
    private String firstName;

    @NotEmpty(message = "last name can not be empty !")
    private String lastName;

    @Past(message =  "date of birth must be in past !")
    @NotNull(message = "dob must be specified !")
    private LocalDate dob;


    @DecimalMin(value = "1000.00", message = "Value must be over 1000.00$")
    @NotNull(message = "Salary can not be empty !")
    private BigDecimal salary;
    @Email(message = "email must be valid !")
    @NotEmpty(message = "email can not be empty !")
    private String email;





}
