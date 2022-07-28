package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "columnss")
public class ColumnsEntity extends EquipmentBaseEntity{

    @Column(name = "obyem")
    private String obyem;
    @Column(name = "diam_korpusa_vn")
    private String diamKorpusaVn;
    @Column(name = "diam_korpusa_vn2")
    private String diamKorpusaVn2;
    @Column(name = "tolwina_st1")
    private String tolwinaSt1;
    @Column(name = "tolwina_st2")
    private String tolwinaSt2;
    @Column(name = "visota")
    private String visota;
    @Column(name = "tip_ustroystva")
    private String tipUstroystva;
    @Column(name = "rab_davlenie")
    private String rabDavlenie;
    @Column(name = "rasc_davlenie")
    private String rascDavlenie;
    @Column(name = "rab_temp")
    private String rabTemp;
    @Column(name = "rasc_temp")
    private String rascTemp;
    @Column(name = "naim_sredi")
    private String naimSredi;
    @Column(name = "massa_app")
    private String massaApp;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "data_vvoda")
    private String dataVvoda;
    @Column(name = "rasc_srok")
    private String rascSrok;
    @Column(name = "marka_korp")
    private String markaKorp;
    @Column(name = "marka_vn_ust")
    private String markaVnUst;
    @Column(name = "deflegmator")
    private String deflegmator;
    @Column(name = "tolwina_defl")
    private String tolwinaDefl;
    @Column(name = "kol_vo_trub")
    private String kolVoTrub;
    @Column(name = "pover_teploob")
    private String poverTeploob;
    @Column(name = "rab_davlenie1")
    private String rabDavlenie1;
    @Column(name = "rasc_davlenie2")
    private String rascDavlenie2;
    @Column(name = "rab_temp1")
    private String rabTemp1;
    @Column(name = "rasc_temp2")
    private String rascTemp2;
    @Column(name = "marka_def")
    private String markaDef;
    @Column(name = "izgotov")
    private String izgotov;
    @Column(name = "data_prov_tex_osmotra")
    private String dataProvTexOsmotra;
    @Column(name = "poslisp")
    private String poslisp;
    @Column(name = "tex_osmotr")
    private String texOsmotr;
    @Column(name = "sledisp")
    private String sledisp;
}
