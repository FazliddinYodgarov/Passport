package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "reservoir")
public class ReservoirEntity extends EquipmentBaseEntity{

    @Column(name = "obyem")
    private  String obyem;
    @Column(name = "nar_diametr")
    private  String narDiametr;
    @Column(name = "tolwina_stenki1")
    private  String tolwinaStenki1;
    @Column(name = "tolwina_stenki2")
    private  String tolwinaStenki2;
    @Column(name = "dlina")
    private  String dlina;
    @Column(name = "visota")
    private  String visota;
    @Column(name = "rab_davlenie")
    private  String rabDavlenie;
    @Column(name = "rasc_davlenie")
    private  String rascDavlenie;
    @Column(name = "rab_temp")
    private  String rabTemp;
    @Column(name = "rasctemp")
    private  String rascTemp;
    @Column(name = "naim_sredi")
    private  String naimSredi;
    @Column(name = "god_vipuska")
    private  String godVipuska;
    @Column(name = "rata_vvoda")
    private  String dataVvoda;
    @Column(name = "rasc_srok")
    private  String rascSrok;
    @Column(name = "mat_korpusa")
    private  String matKorpusa;
    @Column(name = "izgotovitel")
    private  String izgotovitel;
    @Column(name = "inf_osvidel")
    private  String infOsvidel;
    @Column(name = "data_prov_tex_osmotra")
    private  String dataProvTexOsmotra;
    @Column(name = "posl_isp")
    private  String poslIsp;
    @Column(name = "tex_osmotr")
    private  String texOsmotr;
    @Column(name = "led_isp")
    private  String ledIsp;
}
