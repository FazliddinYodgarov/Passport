package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.AVODTO;
import com.company.dto.equipments.BoilerDTO;
import com.company.entity.equipments.AVOEntity;
import com.company.entity.equipments.BoilerEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.BoilerRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoilerService {
    @Autowired
    private BoilerRepository boilerRepository;
    @Autowired
    private FactoryService factoryService;


    public BoilerDTO create(BoilerDTO dto) {

        BoilerEntity entity = new BoilerEntity();
        entity.setId(dto.getId());
        entity.setFactoryId(dto.getFactoryId());
        entity.setDepartment(dto.getDepartment());
        entity.setPlant(dto.getPlant());
        entity.setBlock(dto.getBlock());
        entity.setTechnologicalPlace(dto.getTechnologicalPlace());
        entity.setClacification(dto.getClacification());
        entity.setEquipmentIdentification(dto.getEquipmentIdentification());
        entity.setSerialNomer(dto.getSerialNomer());
        entity.setRegistrationNomer(dto.getRegistrationNomer());
        entity.setInventoryNomer(dto.getInventoryNomer());
        entity.setType(dto.getType());
        entity.setCreatedDate(LocalDate.now());
        entity.setEquipmentType(EquipmentType.BOILER);
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimenovanieSredi(dto.getNaimenovanieSredi());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setMaterialKorp(dto.getMaterialKorp());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setInfOsvidetelstvovanii(dto.getInfOsvidetelstvovanii());
        entity.setVisible(Boolean.TRUE);

        this.boilerRepository.save(entity);

        return dto;
    }
    public List<BoilerDTO> getAll() {
        List<BoilerDTO> dtoList = new ArrayList<>();

        List<BoilerEntity> entityPage = boilerRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, BoilerDTO dto) {

        Optional<BoilerEntity> optional = boilerRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        BoilerEntity entity = new BoilerEntity();
        entity.setId(dto.getId());
        entity.setFactoryId(dto.getFactoryId());
        entity.setDepartment(dto.getDepartment());
        entity.setPlant(dto.getPlant());
        entity.setBlock(dto.getBlock());
        entity.setEquipmentType(EquipmentType.BOILER);
        entity.setTechnologicalPlace(dto.getTechnologicalPlace());
        entity.setClacification(dto.getClacification());
        entity.setEquipmentIdentification(dto.getEquipmentIdentification());
        entity.setSerialNomer(dto.getSerialNomer());
        entity.setRegistrationNomer(dto.getRegistrationNomer());
        entity.setInventoryNomer(dto.getInventoryNomer());
        entity.setType(dto.getType());
        entity.setCreatedDate(LocalDate.now());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimenovanieSredi(dto.getNaimenovanieSredi());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setMaterialKorp(dto.getMaterialKorp());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setInfOsvidetelstvovanii(dto.getInfOsvidetelstvovanii());
        this.boilerRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<BoilerDTO> list() {

        List<BoilerDTO> dtoList = new ArrayList<>();

        List<BoilerEntity> entityPage = boilerRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        BoilerDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        boilerRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public BoilerDTO get(Long id) {

        Optional<BoilerEntity> optional = boilerRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public BoilerDTO toDTO(BoilerEntity entity) {

        BoilerDTO dto = new BoilerDTO();
        dto.setId(entity.getId());
        dto.setFactory(factoryService.toDTO(entity.getFactory()));
        dto.setDepartment(entity.getDepartment());
        dto.setPlant(entity.getPlant());
        dto.setBlock(entity.getBlock());
        dto.setTechnologicalPlace(entity.getTechnologicalPlace());
        dto.setClacification(entity.getClacification());
        dto.setEquipmentIdentification(entity.getEquipmentIdentification());
        dto.setSerialNomer(entity.getSerialNomer());
        dto.setRegistrationNomer(entity.getRegistrationNomer());
        dto.setInventoryNomer(entity.getInventoryNomer());
        dto.setType(entity.getType());
        dto.setCreatedDate(LocalDate.now());
        dto.setRabDavlenie(entity.getRabDavlenie());
        dto.setRascDavlenie(entity.getRascDavlenie());
        dto.setRascTemp(entity.getRascTemp());
        dto.setNaimenovanieSredi(entity.getNaimenovanieSredi());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setMaterialKorp(entity.getMaterialKorp());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setInfOsvidetelstvovanii(entity.getInfOsvidetelstvovanii());







        return dto;
    }
}
