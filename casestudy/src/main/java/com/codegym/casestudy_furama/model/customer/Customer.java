package com.codegym.casestudy_furama.model.customer;

import com.codegym.casestudy_furama.model.contract.Contract;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Entity(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Enter your name, please !")
    private String name;
    @Column(name = "birth_day")
    @NotBlank(message = "Enter your birthday, please !")
    private String birthDay;
    @Column(name = "gender")
    private String gender;
    @Column(name = "id_card")
    @NotBlank(message = "Enter your identity card, please !")
    private String identityCard;
    @Column(name = "phone")
    @NotBlank(message = "Enter your phone, please !")
    private String phone;
    @Column(name = "email")
    @NotBlank(message = "Enter your email, please !")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "Enter your email, please !")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(int id, String name, String birthDay, String gender, String identityCard, String phone, String email, String address, CustomerType customerType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = simpleDateFormat.parse(customer.getBirthDay());
            int yearOld = LocalDate.now().getYear() - birth.getYear() - 1900;
            int month = LocalDate.now().getMonthValue() - birth.getMonth() - 1;
            int day = LocalDate.now().getDayOfYear() - birth.getDate();

            System.out.println(yearOld);
            System.out.println(day);
            if (!(yearOld >= 18 && yearOld < 100)) {
                errors.rejectValue("birthDay", "birthDay.invalidFormat");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
