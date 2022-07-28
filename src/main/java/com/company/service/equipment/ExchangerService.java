package com.company.service.equipment;


import com.company.dto.ActionDTO;
import com.company.dto.equipments.ExchangerDTO;
import com.company.entity.equipments.ExchangerEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.ExchangerRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ExchangerService {

    @Autowired
    private ExchangerRepository exchangerRepository;
    @Autowired
    private FactoryService factoryService;

    public ExchangerDTO create(ExchangerDTO dto) {

        ExchangerEntity entity = new ExchangerEntity();
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
        entity.setWifr(dto.getWifr());
        entity.setVnDiametrKorpusa(dto.getVnDiametrKorpusa());
        entity.setDlinaKorp(dto.getDlinaKorp());
        entity.setTolwinaKorp(dto.getTolwinaKorp());
        entity.setNarDiametr(dto.getNarDiametr());
        entity.setDlinaTrub(dto.getDlinaTrub());
        entity.setTolwinaStenki(dto.getTolwinaStenki());
        entity.setKolVoTrub(dto.getKolVoTrub());
        entity.setCisloXodov(dto.getCisloXodov());
        entity.setPovTeploob(dto.getPovTeploob());
        entity.setRabDavlMejTr(dto.getRabDavlMejTr());
        entity.setRabDavlenieTr(dto.getRabDavlenieTr());
        entity.setRascDavlenieTr(dto.getRascDavlenieTr());
        entity.setRabTempSrediTr(dto.getRabTempSrediTr());
        entity.setRabTempSrediTr(dto.getRabTempSrediTr());
        entity.setRabTempMejTr(dto.getRabTempMejTr());
        entity.setRascTempSrediTr(dto.getRascTempSrediTr());
        entity.setRascTempMejTr(dto.getRascTempMejTr());
        entity.setNaimSrediTr(dto.getNaimSrediTr());
        entity.setNaimSrediMejTr(dto.getNaimSrediMejTr());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setMaterialKorp(dto.getMaterialKorp());
        entity.setMaterialTrub(dto.getMaterialTrub());
        entity.setMassa(dto.getMassa());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslIsp(dto.getPoslIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledIsp(dto.getSledIsp());
        entity.setEquipmentType(EquipmentType.EXCHANGER);
        entity.setVisible(Boolean.TRUE);


        this.exchangerRepository.save(entity);

        return dto;
    }

        public List<ExchangerDTO> getAll() {
            List<ExchangerDTO> dtoList = new ArrayList<>();

            List<ExchangerEntity> entityPage = exchangerRepository.findAll();
            entityPage.forEach(entity -> {
                dtoList.add(toDTO(entity));
            });

            return dtoList;
        }

    public ActionDTO update(Long id, ExchangerDTO dto) {

        Optional<ExchangerEntity> optional = exchangerRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        ExchangerEntity entity = optional.get();
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
        entity.setEquipmentType(EquipmentType.EXCHANGER);
        entity.setCreatedDate(LocalDate.now());
        entity.setWifr(dto.getWifr());
        entity.setVnDiametrKorpusa(dto.getVnDiametrKorpusa());
        entity.setDlinaKorp(dto.getDlinaKorp());
        entity.setTolwinaKorp(dto.getTolwinaKorp());
        entity.setNarDiametr(dto.getNarDiametr());
        entity.setDlinaTrub(dto.getDlinaTrub());
        entity.setTolwinaStenki(dto.getTolwinaStenki());
        entity.setKolVoTrub(dto.getKolVoTrub());
        entity.setCisloXodov(dto.getCisloXodov());
        entity.setPovTeploob(dto.getPovTeploob());
        entity.setRabDavlMejTr(dto.getRabDavlMejTr());
        entity.setRabDavlenieTr(dto.getRabDavlenieTr());
        entity.setRascDavlenieTr(dto.getRascDavlenieTr());
        entity.setRabTempSrediTr(dto.getRabTempSrediTr());
        entity.setRabTempSrediTr(dto.getRabTempSrediTr());
        entity.setRabTempMejTr(dto.getRabTempMejTr());
        entity.setRascTempSrediTr(dto.getRascTempSrediTr());
        entity.setRascTempMejTr(dto.getRascTempMejTr());
        entity.setNaimSrediTr(dto.getNaimSrediTr());
        entity.setNaimSrediMejTr(dto.getNaimSrediMejTr());
        entity.setGodVipuska(dto.getGodVipuska());
        dto.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setMaterialKorp(dto.getMaterialKorp());
        entity.setMaterialTrub(dto.getMaterialTrub());
        entity.setMassa(dto.getMassa());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslIsp(dto.getPoslIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledIsp(dto.getSledIsp());
        exchangerRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<ExchangerDTO> list() {

        List<ExchangerDTO> dtoList = new ArrayList<>();

        List<ExchangerEntity> entityPage = exchangerRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        ExchangerDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        exchangerRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public ExchangerDTO get(Long id) {

        Optional<ExchangerEntity> optional = exchangerRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public ExchangerDTO toDTO(ExchangerEntity entity) {

        ExchangerDTO dto = new ExchangerDTO();
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
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setWifr(entity.getWifr());
        dto.setVnDiametrKorpusa(entity.getVnDiametrKorpusa());
        dto.setDlinaKorp(entity.getDlinaKorp());
        dto.setTolwinaKorp(entity.getTolwinaKorp());
        dto.setNarDiametr(entity.getNarDiametr());
        dto.setDlinaTrub(entity.getDlinaTrub());
        dto.setTolwinaStenki(entity.getTolwinaStenki());
        dto.setKolVoTrub(entity.getKolVoTrub());
        dto.setCisloXodov(entity.getCisloXodov());
        dto.setPovTeploob(entity.getPovTeploob());
        dto.setRabDavlMejTr(entity.getRabDavlMejTr());
        dto.setRabDavlenieTr(entity.getRabDavlenieTr());
        dto.setRascDavlenieTr(entity.getRascDavlenieTr());
        dto.setRabTempSrediTr(entity.getRabTempSrediTr());
        dto.setRabTempSrediTr(entity.getRabTempSrediTr());
        dto.setRabTempMejTr(entity.getRabTempMejTr());
        dto.setRascTempSrediTr(entity.getRascTempSrediTr());
        dto.setRascTempMejTr(entity.getRascTempMejTr());
        dto.setNaimSrediTr(entity.getNaimSrediTr());
        dto.setNaimSrediMejTr(entity.getNaimSrediMejTr());
        dto.setGodVipuska(entity.getGodVipuska());
        entity.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setMaterialKorp(entity.getMaterialKorp());
        dto.setMaterialTrub(entity.getMaterialTrub());
        dto.setMassa(entity.getMassa());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setDataProvTexOsmotra(entity.getDataProvTexOsmotra());
        dto.setPoslIsp(entity.getPoslIsp());
        dto.setTexOsmotr(entity.getTexOsmotr());
        dto.setSledIsp(entity.getSledIsp());


        return dto;
    }
}
