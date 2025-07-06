package com.devwonder.tunzone.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.devwonder.tunzone.entity.compositeKey.Resellers_customersKey;
import com.devwonder.tunzone.entity.enums.CustomerStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "resellers_customers")
@Entity
public class Resellers_customer {
    @EmbeddedId
    private Resellers_customersKey id;

    @ManyToOne
    @MapsId("resellerId") // Tham chiếu đến trường resellerId trong resellers_customersKey
    @JoinColumn(name = "id_reseller")
    private Reseller reseller;

    @ManyToOne
    @MapsId("customerId") // Tham chiếu đến trường customerId trong resellers_customersKey
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Column(
        name = "customer_type",
        nullable = false,
        unique = false,
        length = 30
    )
    private String customer_type;

    @Column(
        name = "total_spent",
        nullable = false,
        precision = 14, 
        scale = 2,
        unique = false
    )
    private BigDecimal total_spent;

    @Column(
        name = "discount",
        nullable = false,
        precision = 5, 
        scale = 2,
        unique = false
    )
    private BigDecimal discount;

    @Column(
        name = "last_purchase_date",
        nullable = false,
        unique = false
    )
    private LocalDate last_purchase_date;

    @Column(
        name = "registration_date",
        nullable = false,
        unique = false
    )
    private LocalDate registration_date;   

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status",
        nullable = false,
        unique = false
    )
    private CustomerStatus status;
}
