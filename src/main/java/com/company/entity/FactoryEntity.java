package com.company.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "factory")
public class FactoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "factory_name")
    private String factoryName;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
