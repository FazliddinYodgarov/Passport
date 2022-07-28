package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.AVODTO;
import com.company.dto.equipments.ExchangerDTO;
import com.company.entity.equipments.AVOEntity;
import com.company.entity.equipments.ExchangerEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.AVORepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AVOService {
    @Autowired
    private AVORepository avoRepository ;
    @Autowired
    private FactoryService factoryService;


    public AVODTO create(AVODTO dto) {

        AVOEntity entity = new AVOEntity();
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
        entity.setEquipmentType(EquipmentType.AVO);
        entity.setWifr(dto.getWifr());
        entity.setCisloXodov(dto.getCisloXodov());
        entity.setKolVoSeksiy(dto.getKolVoSeksiy());
        entity.setPoverTeplo(dto.getPoverTeplo());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRascTemp(dto.getRascTemp());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setTipLopastey(dto.getTipLopastey());
        entity.setDiametrKolesa(dto.getDiametrKolesa());
        entity.setMarkaTrubi(dto.getMarkaTrubi());
        entity.setIzgotov(dto.getIzgotov());
        entity.setTipDvig(dto.getTipDvig());
        entity.setMarkDvig(dto.getMarkDvig());
        entity.setMownostDvig(dto.getMownostDvig());
        entity.setCastotaVraw(dto.getCastotaVraw());
        entity.setVisible(Boolean.TRUE);


        this.avoRepository.save(entity);

        return dto;
    }
    public List<AVODTO> getAll() {
        List<AVODTO> dtoList = new ArrayList<>();

        List<AVOEntity> entityPage = avoRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, AVODTO dto) {

        Optional<AVOEntity> optional = avoRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        AVOEntity entity = new AVOEntity();
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
        entity.setEquipmentType(EquipmentType.AVO);
        entity.setCreatedDate(LocalDate.now());
        entity.setWifr(dto.getWifr());
        entity.setCisloXodov(dto.getCisloXodov());
        entity.setKolVoSeksiy(dto.getKolVoSeksiy());
        entity.setPoverTeplo(dto.getPoverTeplo());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRascTemp(dto.getRascTemp());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setTipLopastey(dto.getTipLopastey());
        entity.setDiametrKolesa(dto.getDiametrKolesa());
        entity.setMarkaTrubi(dto.getMarkaTrubi());
        entity.setIzgotov(dto.getIzgotov());
        entity.setTipDvig(dto.getTipDvig());
        entity.setMarkDvig(dto.getMarkDvig());
        entity.setMownostDvig(dto.getMownostDvig());
        entity.setCastotaVraw(dto.getCastotaVraw());
        this.avoRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<AVODTO> list() {

        List<AVODTO> dtoList = new ArrayList<>();

        List<AVOEntity> entityPage = avoRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        AVODTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        avoRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public AVODTO get(Long id) {

        Optional<AVOEntity> optional = avoRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public AVODTO toDTO(AVOEntity entity) {

        AVODTO dto = new AVODTO();
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
        dto.setWifr(entity.getWifr());
        dto.setCisloXodov(entity.getCisloXodov());
        dto.setKolVoSeksiy(entity.getKolVoSeksiy());
        dto.setPoverTeplo(entity.getPoverTeplo());
        dto.setRabDavlenie(entity.getRabDavlenie());
        dto.setRascDavlenie(entity.getRascDavlenie());
        dto.setRascTemp(entity.getRascTemp());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setTipLopastey(entity.getTipLopastey());
        dto.setDiametrKolesa(entity.getDiametrKolesa());
        dto.setMarkaTrubi(entity.getMarkaTrubi());
        dto.setIzgotov(entity.getIzgotov());
        dto.setTipDvig(entity.getTipDvig());
        dto.setMarkDvig(entity.getMarkDvig());
        dto.setMownostDvig(entity.getMownostDvig());
        dto.setCastotaVraw(entity.getCastotaVraw());



        return dto;
    }
}
