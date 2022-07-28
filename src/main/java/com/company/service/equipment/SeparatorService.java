package com.company.service.equipment;


import com.company.dto.ActionDTO;
import com.company.dto.equipments.SeparatorDTO;
import com.company.entity.equipments.SeparatorEntity;
import com.company.repository.equipment.SeparatorRepository;
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
public class SeparatorService {

    @Autowired
    private SeparatorRepository separatorRepository;
    @Autowired
    private FactoryService factoryService;

    public SeparatorDTO create(SeparatorDTO dto) {
        SeparatorEntity entity = new SeparatorEntity();
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
        entity.setCreatedDate(LocalDate.from(LocalDateTime.now()));
        entity.setCapacity(dto.getCapacity());
        entity.setMassa(dto.getMassa());
        entity.setVnutrenniyDiametr(dto.getVnutrenniyDiametr());
        entity.setDlinaKorpusa(dto.getDlinaKorpusa());
        entity.setTolshinaStenkiKorpusa(dto.getTolshinaStenkiKorpusa());
        entity.setRabDavlenieKorp(dto.getRabDavlenieKorp());
        entity.setRascDavlenieKorp(dto.getRascDavlenieKorp());
        entity.setRabTempSredi(dto.getRabTempSredi());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimenovanieSredi(dto.getNaimenovanieSredi());
        entity.setRabDavleniePodog(dto.getRabDavleniePodog());
        entity.setRascDavleniepPodog(dto.getRascDavleniepPodog());
        entity.setRabTempPodog(dto.getRabTempPodog());
        entity.setRascTempPodog(dto.getRascTempPodog());
        entity.setNaimSrediPodog(dto.getNaimSrediPodog());
        entity.setPoverxTeploobPodog(dto.getPoverxTeploobPodog());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setRegNumber(dto.getRegNumber());
        entity.setMaterialKorpusa(dto.getMaterialKorpusa());
        entity.setMaterialPodog(dto.getMaterialPodog());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setDataProvTexOsmotra(entity.getDataProvTexOsmotra());
        entity.setPosIsp(dto.getPosIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledIsp(dto.getSledIsp());
        entity.setEquipmentType(EquipmentType.SEPARATOR);
        entity.setVisible(Boolean.TRUE);

        this.separatorRepository.save(entity);

        return dto;
    }

    public List<SeparatorDTO> getAll() {
        List<SeparatorDTO> dtoList = new ArrayList<>();

        List<SeparatorEntity> entityPage = separatorRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });
        return dtoList;
    }


    public ActionDTO update(Long id, SeparatorDTO dto) {

        Optional<SeparatorEntity> optional = separatorRepository.findById(id);

        if (optional.isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }
        SeparatorEntity entity = optional.get();
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
        entity.setCreatedDate(LocalDate.from(LocalDateTime.now()));
        entity.setCapacity(dto.getCapacity());
        entity.setMassa(dto.getMassa());
        entity.setVnutrenniyDiametr(dto.getVnutrenniyDiametr());
        entity.setDlinaKorpusa(dto.getDlinaKorpusa());
        entity.setTolshinaStenkiKorpusa(dto.getTolshinaStenkiKorpusa());
        entity.setRabDavlenieKorp(dto.getRabDavlenieKorp());
        entity.setRascDavlenieKorp(dto.getRascDavlenieKorp());
        entity.setRabTempSredi(dto.getRabTempSredi());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimenovanieSredi(dto.getNaimenovanieSredi());
        entity.setRabDavleniePodog(dto.getRabDavleniePodog());
        entity.setRascDavleniepPodog(dto.getRascDavleniepPodog());
        entity.setRabTempPodog(dto.getRabTempPodog());
        entity.setRascTempPodog(dto.getRascTempPodog());
        entity.setNaimSrediPodog(dto.getNaimSrediPodog());
        entity.setPoverxTeploobPodog(dto.getPoverxTeploobPodog());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setRegNumber(dto.getRegNumber());
        entity.setMaterialKorpusa(dto.getMaterialKorpusa());
        entity.setMaterialPodog(dto.getMaterialPodog());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setDataProvTexOsmotra(entity.getDataProvTexOsmotra());
        entity.setPosIsp(dto.getPosIsp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledIsp(dto.getSledIsp());
        this.separatorRepository.save(entity);

        return new ActionDTO(false);
    }


    public ActionDTO delete(Long id) {

        SeparatorDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        separatorRepository.deleteById(id);

        return new ActionDTO(false);
    }

    public SeparatorDTO get(Long id) {

        Optional<SeparatorEntity> optional = separatorRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }
        SeparatorEntity entity= optional.get();

        SeparatorDTO dto=new SeparatorDTO();
        dto.setId(entity.getId());
        dto.setFactoryId(entity.getFactoryId());
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
        dto.setCreatedDate(LocalDate.from(LocalDateTime.now()));
        dto.setCapacity(entity.getCapacity());
        dto.setMassa(entity.getMassa());
        dto.setVnutrenniyDiametr(entity.getVnutrenniyDiametr());
        dto.setDlinaKorpusa(entity.getDlinaKorpusa());
        dto.setTolshinaStenkiKorpusa(entity.getTolshinaStenkiKorpusa());
        dto.setRabDavlenieKorp(entity.getRabDavlenieKorp());
        dto.setRascDavlenieKorp(entity.getRascDavlenieKorp());
        dto.setRabTempSredi(entity.getRabTempSredi());
        dto.setRascTemp(entity.getRascTemp());
        dto.setNaimenovanieSredi(entity.getNaimenovanieSredi());
        dto.setRabDavleniePodog(entity.getRabDavleniePodog());
        dto.setRascDavleniepPodog(entity.getRascDavleniepPodog());
        dto.setRabTempPodog(entity.getRabTempPodog());
        dto.setRascTempPodog(entity.getRascTempPodog());
        dto.setNaimSrediPodog(entity.getNaimSrediPodog());
        dto.setPoverxTeploobPodog(entity.getPoverxTeploobPodog());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setRegNumber(entity.getRegNumber());
        dto.setMaterialKorpusa(entity.getMaterialKorpusa());
        dto.setMaterialPodog(entity.getMaterialPodog());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        dto.setPosIsp(entity.getPosIsp());
        dto.setTexOsmotr(entity.getTexOsmotr());
        dto.setSledIsp(entity.getSledIsp());

        return toDTO(optional.get());
    }

    public SeparatorDTO toDTO(SeparatorEntity entity) {


        SeparatorDTO dto = new SeparatorDTO();

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
        dto.setCreatedDate(LocalDate.from(LocalDateTime.now()));
        dto.setCapacity(entity.getCapacity());
        dto.setMassa(entity.getMassa());
        dto.setVnutrenniyDiametr(entity.getVnutrenniyDiametr());
        dto.setDlinaKorpusa(entity.getDlinaKorpusa());
        dto.setTolshinaStenkiKorpusa(entity.getTolshinaStenkiKorpusa());
        dto.setRabDavlenieKorp(entity.getRabDavlenieKorp());
        dto.setRascDavlenieKorp(entity.getRascDavlenieKorp());
        dto.setRabTempSredi(entity.getRabTempSredi());
        dto.setRascTemp(entity.getRascTemp());
        dto.setNaimenovanieSredi(entity.getNaimenovanieSredi());
        dto.setRabDavleniePodog(entity.getRabDavleniePodog());
        dto.setRascDavleniepPodog(entity.getRascDavleniepPodog());
        dto.setRabTempPodog(entity.getRabTempPodog());
        dto.setRascTempPodog(entity.getRascTempPodog());
        dto.setNaimSrediPodog(entity.getNaimSrediPodog());
        dto.setPoverxTeploobPodog(entity.getPoverxTeploobPodog());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setRegNumber(entity.getRegNumber());
        dto.setMaterialKorpusa(entity.getMaterialKorpusa());
        dto.setMaterialPodog(entity.getMaterialPodog());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        dto.setPosIsp(entity.getPosIsp());
        dto.setTexOsmotr(entity.getTexOsmotr());
        dto.setSledIsp(entity.getSledIsp());

        return dto;

    }


}
