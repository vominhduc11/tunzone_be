package com.devwonder.tunzone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Table(name = "customer_products")
@Entity
public class Customer_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "status",
            nullable = false,
            length = 30
    )
    private String status;

    @Column(
            name = "remaining_time",
            nullable = false
    )
    private int remaining_time;

    @Column(
            name = "expiry_date",
            nullable = false
    )
    private LocalDate expiry_date;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer_order")
    private Customer_order customer_order;

    @OneToMany(mappedBy = "customerProduct", fetch = FetchType.LAZY)
    private Set<Warranty_request> warrantyRequests;
}
