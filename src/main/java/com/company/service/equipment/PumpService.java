package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.PipelineDTO;
import com.company.dto.equipments.PumpDTO;
import com.company.entity.equipments.PipelineEntity;
import com.company.entity.equipments.PumpEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.PumpRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PumpService {

    @Autowired
    private PumpRepository pumpRepository;
    @Autowired
    private FactoryService factoryService;


    public PumpDTO create(PumpDTO dto) {

        PumpEntity entity = new PumpEntity();
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
        entity.setEquipmentType(EquipmentType.PUMP);
        entity.setRasxod(dto.getRasxod());
        entity.setDavlenie(dto.getDavlenie());
        entity.setCastotaVraweniya(dto.getCastotaVraweniya());
        entity.setRabSreda(dto.getRabSreda());
        entity.setRabTemperatura(dto.getRabTemperatura());
        entity.setMownostNasosa(dto.getMownostNasosa());
        entity.setMownostEldvigatelya(dto.getMownostEldvigatelya());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setTipUplotnenia(dto.getTipUplotnenia());
        entity.setModelUplotnenia(dto.getModelUplotnenia());
        entity.setIzgotovitelUplotnenia(dto.getIzgotovitelUplotnenia());
        entity.setDavlenieNaVxode(dto.getDavlenieNaVxode());
        entity.setDavlenieNaVixode(dto.getDavlenieNaVixode());
        entity.setTipReduktora(dto.getTipReduktora());
        entity.setModel2(dto.getModel2());
        entity.setZavodskoyNomer3(dto.getZavodskoyNomer3());
        entity.setRegNomer4(dto.getRegNomer4());
        entity.setCisloPeredac(dto.getCisloPeredac());
        entity.setIzgotovitelReduktora(dto.getIzgotovitelReduktora());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setGodvipuska(dto.getGodvipuska());
        entity.setTipPodwipnikov(dto.getTipPodwipnikov());
        entity.setMarkaMasla(dto.getMarkaMasla());
        entity.setObyem(dto.getObyem());
        entity.setVisible(Boolean.TRUE);


        this.pumpRepository.save(entity);
        return dto;
    }

    public List<PumpDTO> getAll() {
        List<PumpDTO> dtoList = new ArrayList<>();

        List<PumpEntity> entityPage = pumpRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, PumpDTO dto) {

        Optional<PumpEntity> optional = pumpRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        PumpEntity entity = new PumpEntity();
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
        entity.setEquipmentType(EquipmentType.PUMP);
        entity.setCreatedDate(LocalDate.now());
        entity.setRasxod(dto.getRasxod());
        entity.setDavlenie(dto.getDavlenie());
        entity.setCastotaVraweniya(dto.getCastotaVraweniya());
        entity.setRabSreda(dto.getRabSreda());
        entity.setRabTemperatura(dto.getRabTemperatura());
        entity.setMownostNasosa(dto.getMownostNasosa());
        entity.setMownostEldvigatelya(dto.getMownostEldvigatelya());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setTipUplotnenia(dto.getTipUplotnenia());
        entity.setModelUplotnenia(dto.getModelUplotnenia());
        entity.setIzgotovitelUplotnenia(dto.getIzgotovitelUplotnenia());
        entity.setDavlenieNaVxode(dto.getDavlenieNaVxode());
        entity.setDavlenieNaVixode(dto.getDavlenieNaVixode());
        entity.setTipReduktora(dto.getTipReduktora());
        entity.setModel2(dto.getModel2());
        entity.setZavodskoyNomer3(dto.getZavodskoyNomer3());
        entity.setRegNomer4(dto.getRegNomer4());
        entity.setCisloPeredac(dto.getCisloPeredac());
        entity.setIzgotovitelReduktora(dto.getIzgotovitelReduktora());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setGodvipuska(dto.getGodvipuska());
        entity.setTipPodwipnikov(dto.getTipPodwipnikov());
        entity.setMarkaMasla(dto.getMarkaMasla());
        entity.setObyem(dto.getObyem());




        this.pumpRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<PumpDTO> list() {

        List<PumpDTO> dtoList = new ArrayList<>();

        List<PumpEntity> entityPage = pumpRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        PumpDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        pumpRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public PumpDTO get(Long id) {

        Optional<PumpEntity> optional = pumpRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public PumpDTO toDTO(PumpEntity entity) {

        PumpDTO dto = new PumpDTO();

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
        dto.setRasxod(entity.getRasxod());
        dto.setDavlenie(entity.getDavlenie());
        dto.setCastotaVraweniya(entity.getCastotaVraweniya());
        dto.setRabSreda(entity.getRabSreda());
        dto.setRabTemperatura(entity.getRabTemperatura());
        dto.setMownostNasosa(entity.getMownostNasosa());
        dto.setMownostEldvigatelya(entity.getMownostEldvigatelya());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setTipUplotnenia(entity.getTipUplotnenia());
        dto.setModelUplotnenia(entity.getModelUplotnenia());
        dto.setIzgotovitelUplotnenia(entity.getIzgotovitelUplotnenia());
        dto.setDavlenieNaVxode(entity.getDavlenieNaVxode());
        dto.setDavlenieNaVixode(entity.getDavlenieNaVixode());
        dto.setTipReduktora(entity.getTipReduktora());
        dto.setModel2(entity.getModel2());
        dto.setZavodskoyNomer3(entity.getZavodskoyNomer3());
        dto.setRegNomer4(entity.getRegNomer4());
        dto.setCisloPeredac(entity.getCisloPeredac());
        dto.setIzgotovitelReduktora(entity.getIzgotovitelReduktora());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setGodvipuska(entity.getGodvipuska());
        dto.setTipPodwipnikov(entity.getTipPodwipnikov());
        dto.setMarkaMasla(entity.getMarkaMasla());
        dto.setObyem(entity.getObyem());






        return dto;
    }
}
