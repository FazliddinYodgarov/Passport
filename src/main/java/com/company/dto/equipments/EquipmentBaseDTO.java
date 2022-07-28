package com.company.dto.equipments;

import com.company.dto.FactoryDTO;
import com.company.type.EquipmentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EquipmentBaseDTO {

    private Long id;
    private Long factoryId;
    private FactoryDTO factory;
    private String department;
    private String plant;
    private String block;
    private String technologicalPlace;
    private String clacification;
    private String equipmentIdentification;
    private String serialNomer;
    private String registrationNomer;
    private String inventoryNomer;
    private String type;
    private LocalDate createdDate;

    private EquipmentType equipmentType;
}
