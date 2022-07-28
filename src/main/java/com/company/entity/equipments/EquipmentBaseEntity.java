package com.company.entity.equipments;

import com.company.entity.FactoryEntity;
import com.company.service.equipment.BoilerService;
import com.company.type.EquipmentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

;

@MappedSuperclass
@Getter
@Setter
public class EquipmentBaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "plant", nullable = false)
    private String plant;
    @Column(name = "block", nullable = false)
    private String block;
    @Column(name = "technological_place", nullable = false)
    private String technologicalPlace;
    @Column(name = "clacification", nullable = false)
    private String clacification;
    @Column(name = "equipment_nidentification", nullable = false)
    private String equipmentIdentification;
    @Column(name = "serial_nomer", nullable = false)
    private String serialNomer;
    @Column(name = "registration_nomer", nullable = false)
    private String registrationNomer;
    @Column(name = "inventory_nomer", nullable = false)
    private String inventoryNomer;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "factory_id", nullable = false)
    private Long factoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factory_id", insertable = false, updatable = false)
    private FactoryEntity factory;

    @Enumerated(EnumType.STRING)
    @Column(name = "equipment_type")
    private EquipmentType equipmentType;

    @Column(name = "visible")
    private Boolean visible = Boolean.TRUE;
}
