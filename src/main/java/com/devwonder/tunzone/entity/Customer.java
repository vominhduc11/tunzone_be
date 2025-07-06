package com.devwonder.tunzone.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("customer-type")
public class Customer extends Account{
    @Column(
        name = "name", 
        nullable = false,
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
        name = "phone",
        nullable = false,
        unique = true,
        length = 15
    )
    private String phone;

    @Column(
        name = "address",
        length = 100
    )
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Resellers_customer> resellersCustomers;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Customer_order> customer_orders;
}
