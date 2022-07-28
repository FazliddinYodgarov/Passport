package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.ReservoirDTO;
import com.company.entity.equipments.ReservoirEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.ReservoirRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservoirService {
    @Autowired
    private ReservoirRepository reservoirRepository;
    @Autowired
    private FactoryService factoryService;


    public ReservoirDTO create(ReservoirDTO dto) {

        ReservoirEntity entity = new ReservoirEntity();
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
        entity.setEquipmentType(EquipmentType.RESERVOIR);
        entity.setLedIsp(dto.getObyem());
        entity.setDlina(dto.getNarDiametr());
        entity.setNarDiametr(dto.getTolwinaStenki1());
        entity.setTolwinaStenki2(dto.getTolwinaStenki2());
        entity.setDlina(dto.getDlina());
        entity.setVisota(dto.getVisota());
        entity.setDlina(dto.getRabDavlenie());
        entity.setRabDavlenie(dto.getRascDavlenie());
        entity.setRabTemp(dto.getRabTemp());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimSredi(dto.getNaimSredi());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setMatKorpusa(dto.getMatKorpusa());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setInfOsvidel(dto.getInfOsvidel());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslIsp(dto.getPoslIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setLedIsp(dto.getLedIsp());
        entity.setVisible(Boolean.TRUE);

        this.reservoirRepository.save(entity);
        return dto;
    }
    public List<ReservoirDTO> getAll() {
        List<ReservoirDTO> dtoList = new ArrayList<>();

        List<ReservoirEntity> entityPage = reservoirRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, ReservoirDTO dto) {

        Optional<ReservoirEntity> optional = reservoirRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        ReservoirEntity entity = new ReservoirEntity();
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
        entity.setEquipmentType(EquipmentType.RESERVOIR);
        entity.setCreatedDate(LocalDate.now());
        entity.setLedIsp(dto.getObyem());
        entity.setDlina(dto.getNarDiametr());
        entity.setNarDiametr(dto.getTolwinaStenki1());
        entity.setTolwinaStenki2(dto.getTolwinaStenki2());
        entity.setDlina(dto.getDlina());
        entity.setVisota(dto.getVisota());
        entity.setDlina(dto.getRabDavlenie());
        entity.setRabDavlenie(dto.getRascDavlenie());
        entity.setRabTemp(dto.getRabTemp());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimSredi(dto.getNaimSredi());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setMatKorpusa(dto.getMatKorpusa());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setInfOsvidel(dto.getInfOsvidel());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslIsp(dto.getPoslIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setLedIsp(dto.getLedIsp());

        this.reservoirRepository.save(entity);


        return new ActionDTO(false);
    }

    public List<ReservoirDTO> list() {

        List<ReservoirDTO> dtoList = new ArrayList<>();

        List<ReservoirEntity> entityPage = reservoirRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        ReservoirDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        reservoirRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public ReservoirDTO get(Long id) {

        Optional<ReservoirEntity> optional = reservoirRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public ReservoirDTO toDTO(ReservoirEntity entity) {

        ReservoirDTO dto = new ReservoirDTO();

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
        dto.setLedIsp(entity.getObyem());
        dto.setDlina(entity.getNarDiametr());
        dto.setNarDiametr(entity.getTolwinaStenki1());
        dto.setTolwinaStenki2(entity.getTolwinaStenki2());
        dto.setDlina(entity.getDlina());
        dto.setVisota(entity.getVisota());
        dto.setDlina(entity.getRabDavlenie());
        dto.setRabDavlenie(entity.getRascDavlenie());
        dto.setRabTemp(entity.getRabTemp());
        dto.setRascTemp(entity.getRascTemp());
        dto.setNaimSredi(entity.getNaimSredi());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setMatKorpusa(entity.getMatKorpusa());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setInfOsvidel(entity.getInfOsvidel());
        dto.setDataProvTexOsmotra(entity.getDataProvTexOsmotra());
        dto.setPoslIsp(entity.getPoslIsp());
        dto.setTexOsmotr(entity.getTexOsmotr());
        dto.setLedIsp(entity.getLedIsp());

        return dto;
    }
}
