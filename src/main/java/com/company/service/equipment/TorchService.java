package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.TorchDTO;
import com.company.entity.equipments.TorchEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.TorchRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TorchService {
    @Autowired
    private TorchRepository torchRepository;
    @Autowired
    private FactoryService factoryService;


    public TorchDTO create(TorchDTO dto) {

        TorchEntity entity = new TorchEntity();
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
        entity.setEquipmentType(EquipmentType.TORCH);
        entity.setMaksKolVoSjGaza(dto.getMaksKolVoSjGaza());
        entity.setDiametrStvola(dto.getDiametrStvola());
        entity.setDiametrOgolovka(dto.getDiametrOgolovka());
        entity.setVisotaStvola(dto.getVisotaStvola());
        entity.setDavlenieGazaNaVxode(dto.getDavlenieGazaNaVxode());
        entity.setRejimRabotiUstanivki(dto.getRejimRabotiUstanivki());
        entity.setKolVoDejurnixGorelok(dto.getKolVoDejurnixGorelok());
        entity.setMaterialStvola(dto.getMaterialStvola());
        entity.setDataVvoda(String.valueOf(dto.getDataVvoda()));
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setVisible(Boolean.TRUE);

        this.torchRepository.save(entity);
        return dto;
    }

    public List<TorchDTO> getAll() {
        List<TorchDTO> dtoList = new ArrayList<>();

        List<TorchEntity> entityPage = torchRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, TorchDTO dto) {

        Optional<TorchEntity> optional = torchRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        TorchEntity entity = new TorchEntity();
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
        entity.setEquipmentType(EquipmentType.TORCH);
        entity.setCreatedDate(LocalDate.now());
        entity.setMaksKolVoSjGaza(dto.getMaksKolVoSjGaza());
        entity.setDiametrStvola(dto.getDiametrStvola());
        entity.setDiametrOgolovka(dto.getDiametrOgolovka());
        entity.setVisotaStvola(dto.getVisotaStvola());
        entity.setDavlenieGazaNaVxode(dto.getDavlenieGazaNaVxode());
        entity.setRejimRabotiUstanivki(dto.getRejimRabotiUstanivki());
        entity.setKolVoDejurnixGorelok(dto.getKolVoDejurnixGorelok());
        entity.setMaterialStvola(dto.getMaterialStvola());
        entity.setDataVvoda(String.valueOf(dto.getDataVvoda()));
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setIzgotovitel(dto.getIzgotovitel());
        this.torchRepository.save(entity);


        return new ActionDTO(false);
    }

    public List<TorchDTO> list() {

        List<TorchDTO> dtoList = new ArrayList<>();

        List<TorchEntity> entityPage = torchRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        TorchDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        torchRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public TorchDTO get(Long id) {

        Optional<TorchEntity> optional = torchRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::" +id);
        }

        return toDTO(optional.get());
    }

    public TorchDTO toDTO(TorchEntity entity) {

        TorchDTO dto = new TorchDTO();


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
        dto.setMaksKolVoSjGaza(entity.getMaksKolVoSjGaza());
        dto.setDiametrStvola(entity.getDiametrStvola());
        dto.setDiametrOgolovka(entity.getDiametrOgolovka());
        dto.setVisotaStvola(entity.getVisotaStvola());
        dto.setDavlenieGazaNaVxode(entity.getDavlenieGazaNaVxode());
        dto.setRejimRabotiUstanivki(entity.getRejimRabotiUstanivki());
        dto.setKolVoDejurnixGorelok(entity.getKolVoDejurnixGorelok());
        dto.setMaterialStvola(entity.getMaterialStvola());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setIzgotovitel(entity.getIzgotovitel());
        return dto;
    }
}
