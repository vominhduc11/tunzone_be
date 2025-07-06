package com.devwonder.tunzone.entity;

import java.math.BigDecimal;

import com.devwonder.tunzone.entity.compositeKey.Reseller_orders_product_skusKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "reseller_orders_product_skus")
@Entity
public class Reseller_orders_product_skus {
    @EmbeddedId
    private Reseller_orders_product_skusKey id;

    @MapsId("resellerOrderId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reseller_order resellerOrder;

    @MapsId("productSkusId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSku productSku;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "unit_price", nullable = false, precision = 30)
    private BigDecimal unit_price;

    @Column(name = "line_total", nullable = false, precision = 30)
    private BigDecimal line_total;

    @Column(name = "total", nullable = false, precision = 30)
    private BigDecimal total;

    @Column(name = "discount_percent", nullable = false)
    private int discount_percent;
}
