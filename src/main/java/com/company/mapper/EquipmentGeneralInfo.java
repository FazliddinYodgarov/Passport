package com.company.mapper;

import com.company.type.EquipmentType;

import java.time.LocalDate;

public interface EquipmentGeneralInfo {
    Long getId();

    String getDepartment();

    String getPlant();

    String getBlock();

    String getTechnologicalPlace();

    String getClacification();

    String getEquipmentnIdentification();

    String getRegistrationNomer();
    String getInventoryNomer();
    LocalDate getCreatedDate();
    String getType();


    String getSerialNomer();

    EquipmentType getEquipmentType();

    Long getFactoryId();

    String getFactoryName();

}
