package com.company.dto.equipments;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SeparatorDTO  extends EquipmentBaseDTO {

    private Integer capacity;
    private Integer massa;
    private Integer vnutrenniyDiametr;
    private String dlinaKorpusa;
    private String tolshinaStenkiKorpusa;
    private String rabDavlenieKorp;
    private String rascDavlenieKorp;
    private String rabTempSredi;
    private String rascTemp;
    private String naimenovanieSredi;
    private String rabDavleniePodog;
    private String rascDavleniepPodog;
    private String rabTempPodog;
    private String rascTempPodog;
    private String naimSrediPodog;
    private String poverxTeploobPodog;
    private String godVipuska;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVvoda;
    private String rascSrok;
    private String regNumber;
    private String materialKorpusa;
    private String materialPodog;
    private String izgotovitel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataProvTexOsmotra;
    private String posIsp;
    private String texOsmotr;
    private String sledIsp;
}
