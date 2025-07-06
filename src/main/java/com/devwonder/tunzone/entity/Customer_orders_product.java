package com.devwonder.tunzone.entity;

import com.devwonder.tunzone.entity.compositeKey.Customer_orders_productKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "customer_orders_products")
@Entity
public class Customer_orders_product {
    @EmbeddedId
    private Customer_orders_productKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerOrderId")
    @JoinColumn(name = "id_customer_order")
    private Customer_order customerOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productSkusId")
    @JoinColumn(name = "id_product_skus")
    private ProductSku productSku;

    @Column(
            name = "amount",
            nullable = false
    )
    private int amount;

    @Column(
            name = "discount_percent",
            nullable = false
    )
    private int discount_percent;

    @Column(name = "unit_price",
            nullable = false,
            precision = 30
    )
    private BigDecimal unit_price;

    @Formula("unit_price * amount")
    @Column(name = "line_total",
            nullable = false,
            precision = 30
    )
    private BigDecimal line_total;

    @Formula("(unit_price * amount) * (100 - discount_percent) / 100")
    @Column(name = "total",
            nullable = false,
            precision = 30
    )
    private BigDecimal total;
}
