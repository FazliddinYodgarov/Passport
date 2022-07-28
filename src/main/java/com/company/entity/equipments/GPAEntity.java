package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "gpa")
public class GPAEntity extends EquipmentBaseEntity{

    @Column(name = "GPA")
    private  String GPA;
    @Column(name = "model")
    private  String model;
    @Column(name = "god_vipuska")
    private  String godVipuska;
    @Column(name = "model_komp")
    private  String modelKomp;
    @Column(name = "rasc_davlenie_komp")
    private  String rascDavlenieKomp;
    @Column(name = "rab_davlenie")
    private  String rabDavlenie;
    @Column(name = "podaca")
    private  String podaca;
    @Column(name = "mownost_komp")
    private  String mownostKomp;
    @Column(name = "castota_divl")
    private  String castotaDivl;
    @Column(name = "kol_vo_kolesa")
    private  String kolVoKolesa;
    @Column(name = "mayerial_kolesa")
    private  String mayerialKolesa;
    @Column(name = "vid_uplot")
    private  String vidUplot;
    @Column(name = "marka_uplot")
    private  String markaUplot;
    @Column(name = "izgotov")
    private  String izgotov;
    @Column(name = "model_red")
    private  String modelRed;
    @Column(name = "model_dvig")
    private  String modelDvig;
    @Column(name = "mownost_dv")
    private  String mownostDv;
    @Column(name = "castota_comp")
    private  String castotaComp;
    @Column(name = "rasxod")
    private  String rasxod;
    @Column(name = "rasxodvozd")
    private  String rasxodvozd;
    @Column(name = "izg3")
    private  String izg3;
    @Column(name = "vid_masla")
    private  String vidMasla;
    @Column(name = "plotnost")
    private  String plotnost;
    @Column(name = "obyem_baka_komp")
    private  String obyemBakaKomp;
    @Column(name = "obyem_baka_dvig")
    private  String obyemBakaDvig;
    @Column(name = "vid_filtra")
    private  String vidFiltra;
    @Column(name = "cislo_filtra")
    private  String cisloFiltra;
    @Column(name = "modelpoj_sistemi")
    private  String modelpojSistemi;
    @Column(name = "vid_poj")
    private  String vidPoj;
    @Column(name = "kol_voballonov")
    private  String kolVoballonov;
}
