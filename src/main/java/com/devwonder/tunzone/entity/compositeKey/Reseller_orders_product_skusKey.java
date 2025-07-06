package com.devwonder.tunzone.entity.compositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Reseller_orders_product_skusKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_reseller_order")
    private Long resellerOrderId;

    @Column(name = "id_product_skus")
    private String productSkusId;
}
