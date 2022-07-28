package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.ColumnsDTO;
import com.company.entity.equipments.ColumnsEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.ColumnsRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnsService {
    @Autowired
    private ColumnsRepository columnsRepository;
    @Autowired
    private FactoryService factoryService;


    public ColumnsDTO create(ColumnsDTO dto) {

        ColumnsEntity entity = new ColumnsEntity();
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
        entity.setEquipmentType(EquipmentType.COLUMN);
        entity.setObyem(dto.getObyem());
        entity.setDiamKorpusaVn(dto.getDiamKorpusaVn());
        entity.setDiamKorpusaVn2(dto.getDiamKorpusaVn2());
        entity.setTolwinaSt1(dto.getTolwinaSt1());
        entity.setTolwinaSt2(dto.getTolwinaSt2());
        entity.setVisota(dto.getVisota());
        entity.setTipUstroystva(dto.getTipUstroystva());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRabTemp(dto.getRabTemp());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimSredi(dto.getNaimSredi());
        entity.setMassaApp(dto.getMassaApp());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setMarkaKorp(dto.getMarkaKorp());
        entity.setMarkaVnUst(dto.getMarkaVnUst());
        entity.setDeflegmator(dto.getDeflegmator());
        entity.setTolwinaDefl(dto.getTolwinaDefl());
        entity.setKolVoTrub(dto.getKolVoTrub());
        entity.setPoverTeploob(dto.getPoverTeploob());
        entity.setRabDavlenie1(dto.getRabDavlenie1());
        entity.setRascDavlenie2(dto.getRascDavlenie2());
        entity.setRabTemp1(dto.getRabTemp1());
        entity.setRascTemp2(dto.getRascTemp2());
        entity.setMarkaDef(dto.getMarkaDef());
        entity.setIzgotov(dto.getIzgotov());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslisp(dto.getPoslisp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledisp(dto.getSledisp());
        entity.setVisible(Boolean.TRUE);

        this.columnsRepository.save(entity);

        return dto;
    }
    public List<ColumnsDTO> getAll() {
        List<ColumnsDTO> dtoList = new ArrayList<>();

        List<ColumnsEntity> entityPage = columnsRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, ColumnsDTO dto) {

        Optional<ColumnsEntity> optional = columnsRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        ColumnsEntity entity = new ColumnsEntity();
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
        entity.setEquipmentType(EquipmentType.COLUMN);
        entity.setType(dto.getType());
        entity.setCreatedDate(LocalDate.now());
        entity.setObyem(dto.getObyem());
        entity.setDiamKorpusaVn(dto.getDiamKorpusaVn());
        entity.setDiamKorpusaVn2(dto.getDiamKorpusaVn2());
        entity.setTolwinaSt1(dto.getTolwinaSt1());
        entity.setTolwinaSt2(dto.getTolwinaSt2());
        entity.setVisota(dto.getVisota());
        entity.setTipUstroystva(dto.getTipUstroystva());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setRascDavlenie(dto.getRascDavlenie());
        entity.setRabTemp(dto.getRabTemp());
        entity.setRascTemp(dto.getRascTemp());
        entity.setNaimSredi(dto.getNaimSredi());
        entity.setMassaApp(dto.getMassaApp());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setMarkaKorp(dto.getMarkaKorp());
        entity.setMarkaVnUst(dto.getMarkaVnUst());
        entity.setDeflegmator(dto.getDeflegmator());
        entity.setTolwinaDefl(dto.getTolwinaDefl());
        entity.setKolVoTrub(dto.getKolVoTrub());
        entity.setPoverTeploob(dto.getPoverTeploob());
        entity.setRabDavlenie1(dto.getRabDavlenie1());
        entity.setRascDavlenie2(dto.getRascDavlenie2());
        entity.setRabTemp1(dto.getRabTemp1());
        entity.setRascTemp2(dto.getRascTemp2());
        entity.setMarkaDef(dto.getMarkaDef());
        entity.setIzgotov(dto.getIzgotov());
        entity.setDataProvTexOsmotra(dto.getDataProvTexOsmotra());
        entity.setPoslisp(dto.getPoslisp());
        entity.setTexOsmotr(dto.getTexOsmotr());
        entity.setSledisp(dto.getSledisp());
        this.columnsRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<ColumnsDTO> list() {

        List<ColumnsDTO> dtoList = new ArrayList<>();

        List<ColumnsEntity> entityPage = columnsRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        ColumnsDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        columnsRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public ColumnsDTO get(Long id) {

        Optional<ColumnsEntity> optional = columnsRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public ColumnsDTO toDTO(ColumnsEntity entity) {

        ColumnsDTO dto = new ColumnsDTO();

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
        dto.setObyem(entity.getObyem());
        dto.setDiamKorpusaVn(entity.getDiamKorpusaVn());
        dto.setDiamKorpusaVn2(entity.getDiamKorpusaVn2());
        dto.setTolwinaSt1(entity.getTolwinaSt1());
        dto.setTolwinaSt2(entity.getTolwinaSt2());
        dto.setVisota(entity.getVisota());
        dto.setTipUstroystva(entity.getTipUstroystva());
        dto.setRabDavlenie(entity.getRabDavlenie());
        dto.setRascDavlenie(entity.getRascDavlenie());
        dto.setRabTemp(entity.getRabTemp());
        dto.setRascTemp(entity.getRascTemp());
        dto.setNaimSredi(entity.getNaimSredi());
        dto.setMassaApp(entity.getMassaApp());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setMarkaKorp(entity.getMarkaKorp());
        dto.setMarkaVnUst(entity.getMarkaVnUst());
        dto.setDeflegmator(entity.getDeflegmator());
        dto.setTolwinaDefl(entity.getTolwinaDefl());
        dto.setKolVoTrub(entity.getKolVoTrub());
        dto.setPoverTeploob(entity.getPoverTeploob());
        dto.setRabDavlenie1(entity.getRabDavlenie1());
        dto.setRascDavlenie2(entity.getRascDavlenie2());
        dto.setRabTemp1(entity.getRabTemp1());
        dto.setRascTemp2(entity.getRascTemp2());
        dto.setMarkaDef(entity.getMarkaDef());
        dto.setIzgotov(entity.getIzgotov());
        dto.setDataProvTexOsmotra(entity.getDataProvTexOsmotra());
        dto.setPoslisp(entity.getPoslisp());
        dto.setTexOsmotr(entity.getTexOsmotr());
        dto.setSledisp(entity.getSledisp());



        return dto;
    }

}
