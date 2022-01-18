package com.codegym.example_module.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity(name = "order")
public class Order implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "order_day")
    private String orderDay;
    @Column(name = "quantily")
    private int quantily;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public Order() {
    }

    public Order(int id, String orderDay, int quantily, Product product) {
        this.id = id;
        this.orderDay = orderDay;
        this.quantily = quantily;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;

        String orderDay = order.getOrderDay();
        if (!orderDay.matches("/^(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$/")) {
            errors.rejectValue("orderDay", "orderDay.invalidFormat");
        }

        int quantily = order.getQuantily();
        ValidationUtils.rejectIfEmpty(errors, "quantily", "empty.invalidFormat");
        if (quantily < 0) {
            errors.rejectValue("quantily", "number.invalidFormat");
        }
    }
}
