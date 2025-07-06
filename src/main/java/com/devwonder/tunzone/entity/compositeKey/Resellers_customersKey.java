package com.devwonder.tunzone.entity.compositeKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Embeddable
public class Resellers_customersKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_reseller")
    private Long resellerId;

    @Column(name = "id_customer")
    private Long customerId;
}
