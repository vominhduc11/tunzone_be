package com.devwonder.tunzone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Table(name = "customer_orders")
@Entity
public class Customer_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "purchase_date",
            nullable = false
    )
    private LocalDate purchase_date;

    @Lob
    @Column(
            name = "note",
            nullable = false
    )
    private String note;

    @Column(
            name = "payment_status",
            nullable = false
    )
    private String payment_status;

    @Column(
            name = "payment_method",
            nullable = false
    )
    private String payment_method;

    @Column(
            name = "deleted",
            nullable = false
    )
    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reseller")
    private Reseller reseller;

    @OneToMany(mappedBy = "customerOrder", fetch = FetchType.LAZY)
    private Set<Customer_orders_product> customer_orders_products;
}
