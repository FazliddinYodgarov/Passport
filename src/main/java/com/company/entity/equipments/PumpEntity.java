package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "pump")
public class PumpEntity extends EquipmentBaseEntity{

    @Column(name = "rasxod")
    private String rasxod;
    @Column(name = "davlenie")
    private String davlenie;
    @Column(name = "castota_vraweniya")
    private String castotaVraweniya;
    @Column(name = "rab_sreda")
    private String rabSreda;
    @Column(name = "rab_temperatura")
    private String rabTemperatura;
    @Column(name = "mownost_nasosa")
    private String mownostNasosa;
    @Column(name = "mownost_eldvigatelya")
    private String mownostEldvigatelya;
    @Column(name = "rasc_srok_slujbi")
    private String rascSrokSlujbi;
    @Column(name = "tip_uplotnenia")
    private String tipUplotnenia;
    @Column(name = "model_uplotnenia")
    private String modelUplotnenia;
    @Column(name = "izgotovitel_uplotnenia")
    private String izgotovitelUplotnenia;
    @Column(name = "davlenie_na_vxode")
    private String davlenieNaVxode;
    @Column(name = "davlenie_na_vixode")
    private String davlenieNaVixode;
    @Column(name = "tip_reduktora")
    private String tipReduktora;
    @Column(name = "model2")
    private String model2;
    @Column(name = "zavodskoy_nomer3")
    private String zavodskoyNomer3;
    @Column(name = "reg_nomer4")
    private String regNomer4;
    @Column(name = "cislo_peredac")
    private String cisloPeredac;
    @Column(name = "izgotovitel_reduktora")
    private String izgotovitelReduktora;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "godvipuska")
    private String godvipuska;
    @Column(name = "tip_podwipnikov")
    private String tipPodwipnikov;
    @Column(name = "marka_masla")
    private String markaMasla;
    @Column(name = "obyem")
    private String obyem;
}
