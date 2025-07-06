package com.devwonder.tunzone.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "name", 
        nullable = false, 
        unique = true, 
        length = 30)
    private String name;

    @ManyToMany(
        mappedBy = "roles", 
        fetch = FetchType.LAZY)
    private Set<Account> accounts;

    @ManyToMany(
        mappedBy = "roles", 
        fetch = FetchType.LAZY)
    private Set<Permission> permissions;
}
