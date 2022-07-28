package com.company.repository.custom;

import com.company.dto.equipments.EquipmentBaseDTO;
import com.company.dto.equipments.EquipmentFilterDTO;
import com.company.mapper.EquipmentGeneralInfo;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EquipmentGeneralCustomRepository {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FactoryService factoryService;

    public List<EquipmentBaseDTO> filter(EquipmentFilterDTO dto) {
//        String sqlQuery = "SELECT NEW company.mapper.EquipmentGeneralInfoMapper(ex.id,ex.department,ex.plant,ex.block,ex.technological_place," +
//                "ex.clacification,ex.equipment_nidentification,ex.serial_nomer,ex.registration_nomer,ex.equipment_type) FROM exchanger AS ex";
        String sqlQuery = "";
        StringBuilder builder = new StringBuilder();
        builder.append(" where visible = true ");
        if (dto.getFactoryId() != null && dto.getFactoryId() != -1) {
            builder.append(" and factory_id = " + dto.getFactoryId() + " ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" and department like '%" + dto.getQuery() + "%' ");

        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or plant like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or block like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or technological_place like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or clacification like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or equipment_nidentification like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or serial_nomer like '%" + dto.getQuery() + "%' ");
        }
        if (dto.getQuery() != null && !dto.getQuery().isEmpty()) {
            builder.append(" or registration_nomer like '%" + dto.getQuery() + "%' ");
        }


        if (dto.getEquipmentType().equals(EquipmentType.ALL)) {
            sqlQuery = getAllEquipmentType(builder.toString());
        } else {
            if (dto.getEquipmentType().equals(EquipmentType.EXCHANGER)) {
                sqlQuery = getExchangeType(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.SEPARATOR)) {
                sqlQuery = getSeparator(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.AIR_COMPRESSOR)) {
                sqlQuery = getAirCompressor(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.BOILER)) {
                sqlQuery = getBoiler(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.GPA)) {
                sqlQuery = getGpa(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.TORCH)) {
                sqlQuery = getTorch(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.RESERVOIR)) {
                sqlQuery = getReservoir(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.AVO)) {
                sqlQuery = getAvo(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.PIPELINE)) {
                sqlQuery = getPipeline(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.PUMP)) {
                sqlQuery = getPump(builder.toString());
            } else if (dto.getEquipmentType().equals(EquipmentType.COLUMN)) {
                sqlQuery = getColumnss(builder.toString());
            }
            else if (dto.getEquipmentType().equals(EquipmentType.COMPRESSOR)) {
                sqlQuery = getCompressor(builder.toString());
            }

//            builder.append("equipment_type = '" + dto.getEquipmentType().name() + "' ");
        }

        //
        Query query = entityManager.createNativeQuery(sqlQuery);
        List<Object[]> objectList = query.getResultList();
        List<EquipmentBaseDTO> resultList = mapping(objectList);
        return resultList;
    }

    private List<EquipmentBaseDTO> mapping(List<Object[]> result) {
       /* String s = "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name";*/

        List<EquipmentBaseDTO> dtoList = new LinkedList<>();
        for (Object[] obj : result) {
            EquipmentBaseDTO dto = new EquipmentBaseDTO();
            dto.setId(((BigInteger) obj[0]).longValue());
            dto.setDepartment((String) obj[1]);
            dto.setPlant((String) obj[2]);
            dto.setBlock((String) obj[3]);
            dto.setTechnologicalPlace((String) obj[4]);
            dto.setClacification((String) obj[5]);
            dto.setEquipmentIdentification((String) obj[6]);
            dto.setSerialNomer((String) obj[7]);
            dto.setRegistrationNomer((String) obj[8]);
            dto.setEquipmentType(EquipmentType.valueOf((String) obj[9]));

            Long factoryId = ((BigInteger) obj[10]).longValue();
            String factoryName = (String) obj[11];
            dto.setFactory(factoryService.toDTO(factoryId, factoryName));

            dtoList.add(dto);
        }
        return dtoList;
    }

    private String getAllEquipmentType(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from exchanger  as ex  inner join factory as f on f.id = ex.factory_id  " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from separator  as ex  inner join factory as f on f.id = ex.factory_id  " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from air_compressor  as ex  inner join factory as f on f.id = ex.factory_id  " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from avo  as ex  inner join factory as f on f.id = ex.factory_id  " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from boiler  as ex  inner join factory as f on f.id = ex.factory_id " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from compressor  as ex  inner join factory as f on f.id = ex.factory_id" + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from gpa  as ex  inner join factory as f on f.id = ex.factory_id" + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from pipeline  as ex  inner join factory as f on f.id = ex.factory_id" + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from pump  as ex  inner join factory as f on f.id = ex.factory_id " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from reservoir  as ex  inner join factory as f on f.id = ex.factory_id " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from torch  as ex  inner join factory as f on f.id = ex.factory_id " + temp +
                "UNION ALL\n" +
                "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from columnss  as ex  inner join factory as f on f.id = ex.factory_id " + temp;
    }

    private String getExchangeType(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from exchanger  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getSeparator(String temp) {
        return "select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,\n" +
                "       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,\n" +
                "       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName\n" +
                "from separator  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getAirCompressor(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from air_compressor  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getBoiler(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from boiler  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getGpa(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from gpa  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getPipeline(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from pipeline  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getPump(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from pump  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getTorch(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from torch  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getReservoir(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from reservoir  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getAvo(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from avo  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }

    private String getColumnss(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from columnss  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    } private String getCompressor(String temp) {
        return "select ex.id, department , plant, block, technological_place , clacification," +
                "       equipment_nidentification, serial_nomer, registration_nomer, " +
                "       equipment_type, f.id as fId, f.factory_name " +
                "from compressor  as ex  inner join factory as f on f.id = ex.factory_id  " + temp;
    }





}
