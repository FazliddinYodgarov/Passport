package com.company.dto.equipments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompressorDTO extends EquipmentBaseDTO {
    private String davlenie;
    private String proizvoditelnost;
    private String naIspitaniiDavlenie;
    private String potrebMownost;
    private String napryajenie;
    private String castotaVraw;
    private String tipPodwipnika;
    private String tipuplot;
    private String perekacSreda;
    private String godVipuska;
    private String rascSrokSlujbi;
    private String izgotovitel;
    private String tipdvigatelya;
    private String markaDvigatelya;
    private String mownostDvigatelya;
    private String castotaVraweniya;
    private String podwipnikEldv;

}
