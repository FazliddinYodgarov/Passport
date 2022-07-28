package com.company.dto.equipments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TorchDTO extends EquipmentBaseDTO {
    private String maksKolVoSjGaza;
    private String diametrStvola;
    private String diametrOgolovka;
    private String visotaStvola;
    private String davlenieGazaNaVxode;
    private String rejimRabotiUstanivki;
    private String kolVoDejurnixGorelok;
    private String materialStvola;
    private String dataVvoda;
    private String rascSrokSlujbi;
    private String godVipuska;
    private String izgotovitel;

}
