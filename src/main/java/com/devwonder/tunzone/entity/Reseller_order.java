package com.devwonder.tunzone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "reseller_orders")
@Entity
public class Reseller_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
}
