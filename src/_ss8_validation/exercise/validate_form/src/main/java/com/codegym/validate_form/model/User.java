package com.codegym.validate_form.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Pattern(regexp = "^[A-Za-z]{5,}$", message = "First name is invalid!!")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Pattern(regexp = "^[A-Za-z]{5,}$", message = "Last name is invalid!!")
    private String lastName;

    @Min(18)
    private int age;

    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "it must be 10 character for phone number!")
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email is invalid!")
    private String email;

    public User() {
    }

    public User(Long userId,
                @NotEmpty @Size(min = 5, max = 45) String firstName,
                @NotEmpty @Size(min = 5, max = 45) String lastName, @Min(18) int age,
                @NotBlank(message = "phone number is mandatory") @Pattern(regexp = "^[0-9]{10}", message = "it must be 10 character for phone number!") String phoneNumber,
                @NotBlank(message = "email is mandatory") @Pattern(regexp = "^[0-9]{10}", message = "email is invalid!") String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName,
                @NotEmpty @Size(min = 5, max = 45) String lastName,
                @Min(18) int age,
                @NotBlank(message = "phone number is mandatory") @Pattern(regexp = "^[0-9]{10}", message = "it must be 10 character for phone number!") String phoneNumber,
                @NotBlank(message = "email is mandatory") @Pattern(regexp = "^[0-9]{10}", message = "email is invalid!") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}