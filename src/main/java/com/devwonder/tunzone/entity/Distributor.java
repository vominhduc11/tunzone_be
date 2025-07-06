package com.devwonder.tunzone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "distributor")
@DiscriminatorValue("distributor-type")
public class Distributor extends Account {

    @Column(
            name = "addresses",
            columnDefinition = "text[]",
            nullable = false,
            unique = false
    )
    private List<String> addresses;

    @Column(
            name = "hotlines",
            columnDefinition = "text[]",
            nullable = false,
            unique = false
    )
    private List<String> hotlines;

    @Column(
            name = "emails",
            columnDefinition = "text[]",
            nullable = false,
            unique = false
    )
    private List<String> emails;

    @Column(
            name = "business_hours",
            columnDefinition = "text[]",
            nullable = false,
            unique = false
    )
    private List<String> business_hours;

    @OneToMany(mappedBy = "distributor", fetch = FetchType.LAZY)
    private Set<ProductSku> productSkuses;
}
