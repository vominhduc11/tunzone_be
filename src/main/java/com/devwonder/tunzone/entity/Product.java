package com.devwonder.tunzone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @Column(name = "serial")
    private String serial;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_product_sku")
    private ProductSku productSku;

    @OneToOne(mappedBy = "product",
            fetch = FetchType.EAGER,
            optional = false
    )
    private Customer_product customerProduct;
}
