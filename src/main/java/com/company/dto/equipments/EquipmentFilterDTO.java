package com.company.dto.equipments;

import com.company.type.EquipmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentFilterDTO {
    private EquipmentType equipmentType;
    private Long factoryId;
    private String query;
}
