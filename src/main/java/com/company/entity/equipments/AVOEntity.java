package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "avo")
public class AVOEntity extends EquipmentBaseEntity{

    @Column(name = "wifr")
    private String wifr;
    @Column(name = "cislo_xodov")
    private String cisloXodov;
    @Column(name = "kol_vo_seksiy")
    private String kolVoSeksiy;
    @Column(name = "pover_teplo")
    private String poverTeplo;
    @Column(name = "rab_davlenie")
    private String rabDavlenie;
    @Column(name = "rasc_davlenie")
    private String rascDavlenie;
    @Column(name = "rab_temp_sredi")
    private String rabTempSredi;
    @Column(name = "rasc_temp")
    private String rascTemp;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "data_vvoda")
    private String dataVvoda;
    @Column(name = "rasc_srok")
    private String rascSrok;
    @Column(name = "tip_lopastey")
    private String tipLopastey;
    @Column(name = "diametr_kolesa")
    private String diametrKolesa;
    @Column(name = "marka_trubi")
    private String markaTrubi;
    @Column(name = "izgotov")
    private String izgotov;
    @Column(name = "tip_dvig")
    private String tipDvig;
    @Column(name = "mark_dvig")
    private String markDvig;
    @Column(name = "mownost_dvig")
    private String mownostDvig;
    @Column(name = "castota_vraw")
    private String castotaVraw;
}
