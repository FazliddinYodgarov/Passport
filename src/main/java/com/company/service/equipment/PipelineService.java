package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.PipelineDTO;
import com.company.entity.equipments.PipelineEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.PipelineRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PipelineService {
    @Autowired
    private PipelineRepository pipelineRepository;
    @Autowired
    private FactoryService factoryService;


    public PipelineDTO create(PipelineDTO dto) {

        PipelineEntity entity = new PipelineEntity();
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
        entity.setEquipmentType(EquipmentType.PIPELINE);
        entity.setNaznacenieTruboprovoda(dto.getNaznacenieTruboprovoda());
        entity.setRabSreda(dto.getRabSreda());
        entity.setTempStenki(dto.getTempStenki());
        entity.setDavlenie(dto.getDavlenie());
        entity.setNaimUchastkovPoSxeme(dto.getNaimUchastkovPoSxeme());
        entity.setNarDiametrTrubi(dto.getNarDiametrTrubi());
        entity.setTolwinaStenkiTrubi(dto.getTolwinaStenkiTrubi());
        entity.setDlinaUcastkaTrub(dto.getDlinaUcastkaTrub());
        entity.setMaterialTrub(dto.getMaterialTrub());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setRemont(dto.getRemont());
        entity.setZavodIzgotovitel(dto.getZavodIzgotovitel());
        entity.setTipIzolyacii(dto.getTipIzolyacii());
        entity.setVisible(Boolean.TRUE);




        this.pipelineRepository.save(entity);
        return dto;
    }

    public List<PipelineDTO> getAll() {
        List<PipelineDTO> dtoList = new ArrayList<>();

        List<PipelineEntity> entityPage = pipelineRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, PipelineDTO dto) {

        Optional<PipelineEntity> optional = pipelineRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        PipelineEntity entity = new PipelineEntity();
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
        entity.setEquipmentType(EquipmentType.PIPELINE);
        entity.setCreatedDate(LocalDate.now());
        entity.setNaznacenieTruboprovoda(dto.getNaznacenieTruboprovoda());
        entity.setRabSreda(dto.getRabSreda());
        entity.setTempStenki(dto.getTempStenki());
        entity.setDavlenie(dto.getDavlenie());
        entity.setNaimUchastkovPoSxeme(dto.getNaimUchastkovPoSxeme());
        entity.setNarDiametrTrubi(dto.getNarDiametrTrubi());
        entity.setTolwinaStenkiTrubi(dto.getTolwinaStenkiTrubi());
        entity.setDlinaUcastkaTrub(dto.getDlinaUcastkaTrub());
        entity.setMaterialTrub(dto.getMaterialTrub());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setRemont(dto.getRemont());
        entity.setZavodIzgotovitel(dto.getZavodIzgotovitel());
        entity.setTipIzolyacii(dto.getTipIzolyacii());



        this.pipelineRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<PipelineDTO> list() {

        List<PipelineDTO> dtoList = new ArrayList<>();

        List<PipelineEntity> entityPage = pipelineRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        PipelineDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        pipelineRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public PipelineDTO get(Long id) {

        Optional<PipelineEntity> optional = pipelineRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public PipelineDTO toDTO(PipelineEntity entity) {

        PipelineDTO dto = new PipelineDTO();

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
        dto.setNaznacenieTruboprovoda(entity.getNaznacenieTruboprovoda());
        dto.setRabSreda(entity.getRabSreda());
        dto.setTempStenki(entity.getTempStenki());
        dto.setDavlenie(entity.getDavlenie());
        dto.setNaimUchastkovPoSxeme(entity.getNaimUchastkovPoSxeme());
        dto.setNarDiametrTrubi(entity.getNarDiametrTrubi());
        dto.setTolwinaStenkiTrubi(entity.getTolwinaStenkiTrubi());
        dto.setDlinaUcastkaTrub(entity.getDlinaUcastkaTrub());
        dto.setMaterialTrub(entity.getMaterialTrub());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setRemont(entity.getRemont());
        dto.setZavodIzgotovitel(entity.getZavodIzgotovitel());
        dto.setTipIzolyacii(entity.getTipIzolyacii());



        return dto;
    }
}
