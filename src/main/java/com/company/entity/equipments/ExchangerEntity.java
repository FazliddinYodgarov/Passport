package com.company.entity.equipments;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exchanger")
public class ExchangerEntity extends EquipmentBaseEntity {

    @Column(name = "wifr")
    private String wifr;
    @Column(name = "vn_diametr_korpusa")
    private String vnDiametrKorpusa;
    @Column(name = "dlina_korp")
    private String dlinaKorp;
    @Column(name = "tolwina_korp")
    private String tolwinaKorp;
    @Column(name = "nar_diametr")
    private String narDiametr;
    @Column(name = "dlina_trub")
    private String dlinaTrub;
    @Column(name = "tolwina_stenki")
    private String tolwinaStenki;
    @Column(name = "kol_vo_trub")
    private String kolVoTrub;
    @Column(name = "cislo_xodov")
    private String cisloXodov;
    @Column(name = "pov_teploob")
    private String povTeploob;
    @Column(name = "rab_davlenie_tr")
    private String rabDavlenieTr;
    @Column(name = "rab_davl_mej_tr")
    private String rabDavlMejTr;
    @Column(name = "ras_cavlenie_tr")
    private String rascDavlenieTr;
    @Column(name = "rasc_davl_mej_tr")
    private String rascDavlMejTr;
    @Column(name = "rab_temp_sredi_tr")
    private String rabTempSrediTr;
    @Column(name = "rab_temp_mej_tr")
    private String rabTempMejTr;
    @Column(name = "rasc_temp_sredi_tr")
    private String rascTempSrediTr;
    @Column(name = "rasc_temp_mej_tr")
    private String rascTempMejTr;
    @Column(name = "naim_sredi_tr")
    private String naimSrediTr;
    @Column(name = "naim_sredi_mej_tr")
    private String naimSrediMejTr;
    @Column(name = "god_bvipuska")
    private String godVipuska;
    @Column(name = "data_vvoda")
    private String dataVvoda;
    @Column(name = "rasc_srok_slujbi")
    private String rascSrokSlujbi;
    @Column(name = "material_korp")
    private String materialKorp;
    @Column(name = "material_trub")
    private String materialTrub;
    @Column(name = "massa")
    private String massa;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "data_prov_tex_osmotra")
    private String dataProvTexOsmotra;
    @Column(name = "posl_isp")
    private String poslIsp;
    @Column(name = "tex_osmotr")
    private String texOsmotr;
    @Column(name = "sled_isp")
    private String sledIsp;


/*    private Integer id;
    private String fromData;
    private String toData;
    private String action; // CREATE,UPDATE,DELTE
    private Integer profileId;
    private Integer rowId;
    private LocalDateTime createDate;*/
}
