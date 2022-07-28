package com.company.service.equipment;

import com.company.dto.equipments.EquipmentBaseDTO;
import com.company.dto.equipments.EquipmentFilterDTO;
import com.company.mapper.EquipmentGeneralInfo;
import com.company.repository.custom.EquipmentGeneralCustomRepository;
import com.company.repository.equipment.EquipmentGeneralRepository;
import com.company.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EquipmentGeneralService {
    @Autowired
    private EquipmentGeneralRepository equipmentGeneralRepository;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private EquipmentGeneralCustomRepository equipmentGeneralCustomRepository;


    public List<EquipmentBaseDTO> getEquipmentGeneralInfo() {
        List<EquipmentGeneralInfo> entityList = equipmentGeneralRepository.getEquipmentGeneralInfo();
        List<EquipmentBaseDTO> dtoList = new LinkedList<>();
        for (EquipmentGeneralInfo entity : entityList) {
            EquipmentBaseDTO dto = new EquipmentBaseDTO();
            dto.setId(entity.getId());
            dto.setFactory(factoryService.toDTO(entity.getFactoryId(), entity.getFactoryName()));
            dto.setDepartment(entity.getDepartment());
            dto.setPlant(entity.getPlant());
            dto.setBlock(entity.getBlock());
            dto.setTechnologicalPlace(entity.getTechnologicalPlace());
            dto.setClacification(entity.getClacification());
            dto.setEquipmentIdentification(entity.getEquipmentnIdentification());
            dto.setSerialNomer(entity.getSerialNomer());
            dto.setRegistrationNomer(entity.getRegistrationNomer());
            dto.setType(entity.getType());
            dto.setInventoryNomer(entity.getInventoryNomer());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setEquipmentType(entity.getEquipmentType());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public List<EquipmentBaseDTO> filter(EquipmentFilterDTO filterDTO) {
        List<EquipmentBaseDTO> dtoList  = equipmentGeneralCustomRepository.filter(filterDTO);
       /* List<EquipmentBaseDTO> dtoList = new LinkedList<>();
        for (EquipmentGeneralInfo entity : entityList) {
            EquipmentBaseDTO dto = new EquipmentBaseDTO();
            dto.setId(entity.getId());
            dto.setFactory(factoryService.toDTO(entity.getFactoryId(), entity.getFactoryName()));
            dto.setDepartment(entity.getDepartment());
            dto.setPlant(entity.getPlant());
            dto.setBlock(entity.getBlock());
            dto.setTechnologicalPlace(entity.getTechnologicalPlace());
            dto.setClacification(entity.getClacification());
            dto.setEquipmentIdentification(entity.getEquipmentnIdentification());
            dto.setSerialNomer(entity.getSerialNomer());
            dto.setRegistrationNomer(entity.getRegistrationNomer());
            dto.setType(entity.getType());
            dto.setInventoryNomer(entity.getInventoryNomer());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setEquipmentType(entity.getEquipmentType());

            dtoList.add(dto);
        }*/

        return dtoList;
    }
//    public List<EquipmentBaseDTO> paginationList(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));
//
//        List<EquipmentBaseDTO> list = new ArrayList<>();
//        equipmentGeneralRepository.findByVisible(true, pageable).forEach(courseEntity -> {
//            list.add(toDTO(courseEntity));
//        });
//        if (list.isEmpty()) {
//            throw new ItemNotFoundException("Not Found!");
//        }
//        return list;
//    }

}
