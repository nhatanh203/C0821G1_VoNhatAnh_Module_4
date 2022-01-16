package com.codegym.demo_full_md4.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_day")
    private String birthDay;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
    private UserType userType;

    public User() {
    }

    public User(int id, String name, String birthDay, String gender, String phone, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        String name = user.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "empty.invalidFormat");
        if (name.length() > 45 || name.length() < 5) {
            errors.rejectValue("name", "name.invalidFormat");
        }

        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "empty.invalidFormat");
        if (phone.length() > 11 || phone.length() < 10) {
            errors.rejectValue("phone", "phoneNumber1.invalidFormat");
        }
        if (!phone.startsWith("0")) {
            errors.rejectValue("phone", "phoneNumber2.invalidFormat");
        }
        if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phone", "phoneNumber3.invalidFormat");
        }

//        int birthDay = Integer.parseInt(user.getBirthDay());
//        if (birthDay < 18) {
//            errors.rejectValue("birthDay", "age.invalidFormat");
//        }

        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "empty.invalidFormat");
        if (!email.matches("(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$)")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
}
