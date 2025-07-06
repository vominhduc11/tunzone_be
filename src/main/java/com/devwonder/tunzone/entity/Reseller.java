package com.devwonder.tunzone.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import lombok.Getter;
import lombok.Setter;

@Check(constraints = "rating BETWEEN 1 AND 5")
@Getter
@Setter
@Table(name = "resellers")
@Entity
@DiscriminatorValue("reseller-type")
public class Reseller extends Account {
    @Column(
        name = "name",
        nullable = false,
        unique = false,
        length = 30
    )
    private String name;

    @Column(
        name = "email",
        nullable = false,
        unique = true,
        length = 50
    )
    private String email;

    @Column(
        name = "coor",
        nullable = false,
        unique = true,
        length = 50
    )
    private String coor;

    @Column(
        name = "phone",
        nullable = false,
        unique = true,
        length = 15
    )
    private String phone_number;

    @Column(
        name = "address",
        nullable = false,
        unique = true,
        length = 100
    )
    private String address;

    @Column(
        name = "opening_hours",
        nullable = false,
        unique = false
    )
    private String opening_hours;

    @Column(
        name = "rating",
        nullable = false,
        unique = false
    )
    private int rating;

    @Column(
        name = "services",
        nullable = false, columnDefinition = "TEXT[]",
        unique = false
    )
    private String services;

    @OneToMany(mappedBy = "reseller", fetch = FetchType.LAZY)
    private Set<Resellers_customer> resellersCustomers;

    @OneToMany(mappedBy = "reseller", fetch = FetchType.LAZY)
    private Set<Customer_order> customer_orders;
}
