package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "air_compressor")
public class AirCompressorEntity extends EquipmentBaseEntity {

    @Column(name = "proizvoditelnost")
    private String proizvoditelnost;
    @Column(name = "rab_sreda")
    private String rabSreda;
    @Column(name = "castota_vraw")
    private String castotaVraw;
    @Column(name = "davl_na_vxode")
    private String davlNaVxode;
    @Column(name = "davl_na_vixode")
    private String davlNaVixode;
    @Column(name = "rab_temp_na_vxode")
    private String rabTempNaVxode;
    @Column(name = "rab_temp_na_vixode")
    private String rabTempNaVixode;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "data_vvoda")
    private String dataVvoda;
    @Column(name = "rasc_srok")
    private String rascSrok;
    @Column(name = "tip_uplot")
    private String tipUplot;
    @Column(name = "model_uplot")
    private String modelUplot;
    @Column(name = "izgotovitel_uplot")
    private String izgotovitelUplot;
    @Column(name = "tip_reduktora")
    private String tipReduktora;
    @Column(name = "model_reduktora")
    private String modelReduktora;
    @Column(name = "zavodskoy_nomer2")
    private String zavodskoyNomer2;
    @Column(name = "reg_nomer2")
    private String regNomer2;
    @Column(name = "kol_vo")
    private String kolVo;
    @Column(name = "castota_vrawenia")
    private String castotaVrawenia;
    @Column(name = "cislo_peredac")
    private String cisloPeredac;
    @Column(name = "izgotovitel_reduktora")
    private String izgotovitelReduktora;
    @Column(name = "god_vipuska_reduk")
    private String godVipuskaReduk;
    @Column(name = "tip_podwip")
    private String tipPodwip;
    @Column(name = "naim_turbini")
    private String naimTurbini;
    @Column(name = "model_turbini")
    private String modelTurbini;
    @Column(name = "zavodskoy_nomer6")
    private String zavodskoyNomer6;
    @Column(name = "reg_nomer7")
    private String regNomer7;
    @Column(name = "cast_vrawenia_turb")
    private String castVraweniaTurb;
    @Column(name = "mownost")
    private String mownost;
    @Column(name = "tip_podwipnikov9")
    private String tipPodwipnikov9;
    @Column(name = "izgotovitel_turbini")
    private String izgotovitelTurbini;
    @Column(name = "god_vipuska10")
    private String godVipuska10;
    @Column(name = "marka_masla")
    private String markaMasla;
    @Column(name = "obyem")
    private String obyem;
}
