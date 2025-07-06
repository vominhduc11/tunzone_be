package com.devwonder.tunzone.entity;

import com.devwonder.tunzone.entity.BaseEntity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Set;

@Check(constraints = "rating BETWEEN 1 AND 5")
@Getter
@Setter
@Table(name = "product_skus")
@Entity
public class ProductSku extends BaseAuditEntity {
    @Id
    @Column(name = "sku")
    private String SKU;

    @Column(
            name = "imgs",
            nullable = false,
            columnDefinition = "TEXT[]"
    )
    private List<String> imgs;

    @Column(
            name = "rating",
            nullable = false
    )
    private int rating;

    @Column(
            name = "rating_count",
            nullable = false
    )
    private int rating_count;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "features",
            nullable = false,
            columnDefinition = "TEXT[]"
    )
    private List<String> features;

    @Lob
    @Column(
            name = "spec",
            nullable = false
    )
    private String spec;

    @Lob
    @Column(
            name = "video",
            nullable = false
    )
    private String video;

    @Lob
    @Column(
            name = "description",
            nullable = false
    )
    private String desc;

    @Column(
            name = "in_boxs",
            nullable = false,
            columnDefinition = "TEXT[]"
    )
    private List<String> in_boxs;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(
            name = "faqs",
            nullable = false,
            columnDefinition = "json"
    )
    private String faqs;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(
            name = "wholesale_prices",
            nullable = false,
            columnDefinition = "jsonb"
    )
    private String wholesale_prices;

    @Column(
            name = "inventory_count",
            nullable = false
    )
    private int inventory_count;

    @Column(
            name = "warranty",
            nullable = false
    )
    private int warranty;

    @Column(
            name = "deleted",
            nullable = false
    )
    private boolean deleted = false;

    @OneToMany(mappedBy = "productSku", fetch = FetchType.LAZY)
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_distributor")
    private Distributor distributor;
}
