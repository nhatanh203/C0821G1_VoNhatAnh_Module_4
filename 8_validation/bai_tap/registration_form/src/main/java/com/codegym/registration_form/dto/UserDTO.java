package com.codegym.registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDTO implements Validator {
    private int id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private int age;

    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;

        String firstName = user.getFirstName();
        ValidationUtils.rejectIfEmpty(errors, "firstName", "empty.invalidFormat");
        if (firstName.length() > 45 || firstName.length() < 5) {
            errors.rejectValue("firstName", "firstName.invalidFormat");
        }

        String lastName = user.getLastName();
        ValidationUtils.rejectIfEmpty(errors, "lastName", "empty.invalidFormat");
        if (lastName.length() > 45 || lastName.length() < 2) {
            errors.rejectValue("lastName", "lastName.invalidFormat");
        }

        String phoneNumber = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "empty.invalidFormat");
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber1.invalidFormat");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber2.invalidFormat");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber3.invalidFormat");
        }

        int age = user.getAge();
        if (age < 18) {
            errors.rejectValue("age", "age.invalidFormat");
        }

        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "empty.invalidFormat");
        if (!email.matches("(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$)")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
}
