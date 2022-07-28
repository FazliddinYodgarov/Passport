package com.company.repository.equipment;

import com.company.entity.ProfileEntity;
import com.company.entity.equipments.EquipmentBaseEntity;
import com.company.entity.equipments.ExchangerEntity;
import com.company.mapper.EquipmentGeneralInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentGeneralRepository extends JpaRepository<ExchangerEntity, Long> {



    @Query(value = "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from exchanger  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from separator  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from air_compressor  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from avo  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from boiler  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from compressor  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from gpa  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from pipeline  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from pump  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from reservoir  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from torch  as ex  inner join factory as f on f.id = ex.factory_id\n" +
            "UNION ALL\n" +
            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
            "from columnss  as ex  inner join factory as f on f.id = ex.factory_id", nativeQuery = true)
    List<EquipmentGeneralInfo> getEquipmentGeneralInfo();



//
//    @Query(value = "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from exchanger  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from separator  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from air_compressor  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from avo  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from boiler  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from compressor  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from gpa  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from pipeline  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from pump  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from reservoir  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from torch  as ex  inner join factory as f on f.id = ex.factory_id\n" +
//            "UNION ALL\n" +
//            "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
//            "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
//            "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
//            "from columnss  as ex  inner join factory as f on f.id = ex.factory_id", nativeQuery = true)
//    Page<EquipmentGeneralInfo> findAllEquipments(Pageable pageable);



}
