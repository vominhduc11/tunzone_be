package com.devwonder.tunzone.entity.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class Customer_orders_productKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_customer_order")
    private Long customerOrderId;

    @Column(name = "id_product_skus")
    private String productSkusId;
}
