package com.company.dto.equipments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PipelineDTO extends EquipmentBaseDTO {
    private  String naznacenieTruboprovoda;
    private  String rabSreda;
    private  String tempStenki;
    private  String davlenie;
    private  String naimUchastkovPoSxeme;
    private  String narDiametrTrubi;
    private  String tolwinaStenkiTrubi;
    private  String dlinaUcastkaTrub;
    private  String materialTrub;
    private  String dataVvoda;
    private  String rascSrokSlujbi;
    private  String remont;
    private  String zavodIzgotovitel;
    private  String tipIzolyacii;

}
