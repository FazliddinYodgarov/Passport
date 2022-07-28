package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "compressor")
public class CompressorEntity extends EquipmentBaseEntity{

    @Column(name = "davlenie")
    private String davlenie;
    @Column(name = "proizvoditelnost")
    private String proizvoditelnost;
    @Column(name = "na_ispitanii_davlenie")
    private String naIspitaniiDavlenie;
    @Column(name = "potreb_mownost")
    private String potrebMownost;
    @Column(name = "napryajenie")
    private String napryajenie;
    @Column(name = "castota_vraw")
    private String castotaVraw;
    @Column(name = "tip_podwipnika")
    private String tipPodwipnika;
    @Column(name = "tipuplot")
    private String tipuplot;
    @Column(name = "perekac_sreda")
    private String perekacSreda;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "rasc_srok_slujbi")
    private String rascSrokSlujbi;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "tipdvigatelya")
    private String tipdvigatelya;
    @Column(name = "marka_dvigatelya")
    private String markaDvigatelya;
    @Column(name = "mownost_dvigatelya")
    private String mownostDvigatelya;
    @Column(name = "castota_vraweniya")
    private String castotaVraweniya;
    @Column(name = "podwipnik_eldv")
    private String podwipnikEldv;
}
