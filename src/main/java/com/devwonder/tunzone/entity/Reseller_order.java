package com.devwonder.tunzone.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.devwonder.tunzone.entity.BaseEntity.BaseAuditEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "reseller_orders")
@Entity
public class Reseller_order extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total_item", nullable = false)
    private int total_item;

    @Column(name = "payment_method", nullable = false)
    private String payment_method;

    @Column(name = "payment_status", nullable = false)
    private String payment_status;

    @Column(name = "delivery_status", nullable = false)
    private String delivery_status;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "shipping", nullable = false)
    private BigDecimal shipping;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "estimated_delivery_time", nullable = false)
    private LocalDate estimated_delivery_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @OneToMany(mappedBy = "resellerOrder", fetch = FetchType.LAZY)
    private Set<Reseller_orders_product_skus> resellerOrdersProductSkuses;
}
