package com.company.mapper;

import com.company.type.EquipmentType;

import java.time.LocalDate;

public class EquipmentGeneralInfoMapper {
    Long id;

    String department;

    String plant;

    String block;

    String technologicalPlace;

    String clacification;

    String equipmentnIdentification;

    String serialNomer;
    String registrationNomer;
    String inventoryNomer;
    LocalDate createdDate;
    EquipmentType equipmentType;

    public EquipmentGeneralInfoMapper(String department) {
        this.department = department;
    }

    // constructor

    public EquipmentGeneralInfoMapper(Long id, String department, String plant, String block,
                                      String technologicalPlace, String clacification, String equipmentnIdentification,
                                      String serialNomer, String registrationNomer, String inventoryNomer,
                                      EquipmentType equipmentType) {

        this.id = id;
        this.department = department;
        this.plant = plant;
        this.block = block;
        this.technologicalPlace = technologicalPlace;
        this.clacification = clacification;
        this.equipmentnIdentification = equipmentnIdentification;
        this.serialNomer = serialNomer;
        this.registrationNomer = registrationNomer;
        this.inventoryNomer = inventoryNomer;
        this.equipmentType = equipmentType;


    }
}
