package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "pipeline")
public class PipelineEntity extends EquipmentBaseEntity{
    
    @Column(name = "naznacenie_truboprovoda")
    private  String naznacenieTruboprovoda;
    @Column(name = "rab_sreda")
    private  String rabSreda;
    @Column(name = "temp_stenki")
    private  String tempStenki;
    @Column(name = "davlenie")
    private  String davlenie;
    @Column(name = "naim_uchastkov_po_sxeme")
    private  String naimUchastkovPoSxeme;
    @Column(name = "nar_diametr_trubi")
    private  String narDiametrTrubi;
    @Column(name = "tolwina_stenki_trubi")
    private  String tolwinaStenkiTrubi;
    @Column(name = "dlina_ucastka_trub")
    private  String dlinaUcastkaTrub;
    @Column(name = "material_trub")
    private  String materialTrub;
    @Column(name = "data_vvoda")
    private  String dataVvoda;
    @Column(name = "rasc_srok_slujbi")
    private  String rascSrokSlujbi;
    @Column(name = "remont")
    private  String remont;
    @Column(name = "zavod_izgotovitel")
    private  String zavodIzgotovitel;
    @Column(name = "tip_izolyacii")
    private  String tipIzolyacii;
}
