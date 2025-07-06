package com.devwonder.tunzone.entity;

import com.devwonder.tunzone.entity.BaseEntity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "warranty_requests")
@Entity
public class Warranty_request extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(
            name = "description",
            nullable = false,
            unique = false
    )
    private String desc;

    @Column(
            name = "issue_type",
            nullable = false,
            unique = false,
            length = 30

    )
    private String issue_type;

    @Column(
            name = "status",
            nullable = false,
            unique = false,
            length = 30

    )
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer_products")
    private Customer_product customerProduct;
}
