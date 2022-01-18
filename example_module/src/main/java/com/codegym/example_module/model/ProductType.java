package com.codegym.example_module.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer id;
    @Column(name = "product_type_name")
    private String nameType;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> product;

    public ProductType() {
    }

    public ProductType(Integer id, String nameType, List<Product> product) {
        this.id = id;
        this.nameType = nameType;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
