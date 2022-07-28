package com.company.dto.equipments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BoilerDTO extends  EquipmentBaseDTO{
    private String   rabDavlenie;
    private String rascDavlenie;
    private String rabTemp;
    private String  rascTemp;
    private String  naimenovanieSredi;
    private String godVipuska;
    private String  rascSrokSlujbi;
    private String 	materialKorp;
    private String izgotovitel;
    private String infOsvidetelstvovanii;

}
