package com.company.entity.equipments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "separator")
public class    SeparatorEntity  extends EquipmentBaseEntity {
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "massa")
    private Integer massa;

    @Column(name = "vnutrenniy_diametr")
    private Integer vnutrenniyDiametr;
    @Column(name = "dlina_korpusa")
    private String dlinaKorpusa;
    @Column(name = "tolshina_stenki_korpusa")
    private String tolshinaStenkiKorpusa;
    @Column(name = "rab_davlenie_korp")
    private String rabDavlenieKorp;
    @Column(name = "rasc_davlenie_korp")
    private String rascDavlenieKorp;
    @Column(name = "rab_temp_sredi")
    private String rabTempSredi;
    @Column(name = "rasc_temp")
    private String rascTemp;
    @Column(name = "naimenovanie_sredi")
    private String naimenovanieSredi;
    @Column(name = "rab_davlenie_podog")
    private String rabDavleniePodog;
    @Column(name = "rasc_davleniep_podog")
    private String rascDavleniepPodog;
    @Column(name = "rab_temp_podog")
    private String rabTempPodog;
    @Column(name = "rasc_temp_podog")
    private String rascTempPodog;
    @Column(name = "naim_sredi_podog")
    private String naimSrediPodog;
    @Column(name = "poverx_teploob_podog")
    private String poverxTeploobPodog;
    @Column(name = "god_vipuska")
    private String godVipuska;
    @Column(name = "data_vvoda")
    private LocalDate dataVvoda;
    @Column(name = "rasc_srok")
    private String rascSrok;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "material_korpusa")
    private String materialKorpusa;
    @Column(name = "materialPodog")
    private String materialPodog;
    @Column(name = "izgotovitel")
    private String izgotovitel;
    @Column(name = "data_prov_tex_osmotra")
    private LocalDate dataProvTexOsmotra;
    @Column(name = "posIsp")
    private String posIsp;
    @Column(name = "tex_osmotr")
    private String texOsmotr;
    @Column(name = "sled_isp")
    private String sledIsp;



}
