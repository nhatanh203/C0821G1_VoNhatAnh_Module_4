package com.codegym.casestudy_furama.model.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity(name = "service")
public class Services implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;
    @Column(name = "code_service")
    private String codeService;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    private int area;
    @Column(name = "cost")
    private int cost;
    @Column(name = "number_of_person")
    private int numberOfPerson;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description")
    private String description;
    @Column(name = "pool_area")
    private int poolArea;
    @Column(name = "number_of_floor")
    private int numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    public Services() {
    }

    public Services(Integer id, String codeService, String name, int area, int cost, int numberOfPerson, String standardRoom, String description, int poolArea, int numberOfFloor, ServiceType serviceType) {
        this.id = id;
        this.codeService = codeService;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPerson = numberOfPerson;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
