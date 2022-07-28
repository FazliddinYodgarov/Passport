package com.company.entity;


import com.company.type.ProfileRole;
import com.zaxxer.hikari.util.ClockSource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "profile")
public class ProfileEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "username")
    private String username;
    @Column( name = "password")
    private String password;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ProfileRole role;
    @Column(name = "factory_id", nullable = false)
    private Long factoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factory_id", insertable = false, updatable = false)
    private FactoryEntity factory;

}
