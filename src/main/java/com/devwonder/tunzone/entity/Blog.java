package com.devwonder.tunzone.entity;

import java.time.LocalDate;

import com.devwonder.tunzone.entity.BaseEntity.BaseAuditEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


// Override action khi gọi delete(): cập nhật deleted = true
@Getter
@Setter
@Table(name = "blogs")
@Entity
public class Blog extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "read_time",
        nullable = false
    )
    private int read_time;

    @Column(
        name = "title",
        nullable = false,
        length = 100
    )
    private String title;

    @Column(
        name = "sub_title",
        nullable = false,
        length = 100
    )
    private String sub_title;

    @Column(
        name = "author",
        nullable = false,
        length = 50
    )
    private String author;

    @Column(
        name = "date",
        nullable = false
    )
    private LocalDate date;

    @Column(
        name = "view_count",
        nullable = false
    )
    private int view_count;

    @Column(
        name = "like_count",
        nullable = false
    )
    private int like_count;

    @Column(
        name = "img",
        nullable = false
    )
    private String img;

    @Lob
    @Column(
        name = "content",
        nullable = false
    )
    private String content;

    @Column(
        name = "deleted", 
        nullable = false)
    private boolean deleted = false;
}
