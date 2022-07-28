package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "torch")
public class TorchEntity extends EquipmentBaseEntity{

    @Column(name = "maks_kol_vo_sj_gaza")
    private String maksKolVoSjGaza;
    @Column(name = "diametr_stvola")
    private String diametrStvola;
    @Column(name = "diametr_ogolovka")
    private String diametrOgolovka;
    @Column(name = "visota_stvola")
    private String visotaStvola;
    @Column(name = "davlenie_gaza_na_vxode")
    private String davlenieGazaNaVxode;
    @Column(name = "rejim_raboti_ustanivki")
    private String rejimRabotiUstanivki;
    @Column(name = "kol_vo_dejurnix_gorelok")
    private String kolVoDejurnixGorelok;
    @Column(name = "material_stvola")
    private String materialStvola;
    @Column(name = "data_vvoda")
    private String dataVvoda;
    @Column(name = "rasc_srok_slujbi")
    private String rascSrokSlujbi;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "izgotovitel")
    private String izgotovitel;
}
