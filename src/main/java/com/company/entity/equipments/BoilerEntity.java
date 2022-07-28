package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "boiler")
public class BoilerEntity extends EquipmentBaseEntity{

    @Column(name = "rab_davlenie")
    private String   rabDavlenie;
    @Column(name = "rasc_davlenie")
    private String rascDavlenie;
    @Column(name = "rab_temp")
    private String rabTemp;
    @Column(name = "rasc_temp")
    private String  rascTemp;
    @Column(name = "naimenovanie_sredi")
    private String  naimenovanieSredi;
    @Column(name = "god_vipuska")
    private String  godVipuska;
    @Column(name = "rasc_srok_slujbi")
    private String  rascSrokSlujbi;
    @Column(name = "material_korp")
    private String 	materialKorp;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "inf_osvidetelstvovanii")
    private String infOsvidetelstvovanii;
}
