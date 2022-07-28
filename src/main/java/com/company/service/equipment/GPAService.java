package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.CompressorDTO;
import com.company.dto.equipments.GPADTO;
import com.company.entity.equipments.CompressorEntity;
import com.company.entity.equipments.GPAEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.GPARepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GPAService {
    @Autowired
    private GPARepository gpaRepository;
    @Autowired
    private FactoryService factoryService;


    public GPADTO create(GPADTO dto) {

        GPAEntity entity = new GPAEntity();
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
        entity.setEquipmentType(EquipmentType.GPA);
        entity.setGPA(dto.getGPA());
        entity.setModel(dto.getModel());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setModelKomp(dto.getModelKomp());
        entity.setRascDavlenieKomp(dto.getRascDavlenieKomp());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setPodaca(dto.getPodaca());
        entity.setMownostKomp(dto.getMownostKomp());
        entity.setCastotaDivl(dto.getCastotaDivl());
        entity.setKolVoKolesa(dto.getKolVoKolesa());
        entity.setMayerialKolesa(dto.getMayerialKolesa());
        entity.setVidUplot(dto.getVidUplot());
        entity.setMarkaUplot(dto.getMarkaUplot());
        entity.setIzgotov(dto.getIzgotov());
        entity.setModelDvig(dto.getModelDvig());
        entity.setModelRed(dto.getModelRed());
        entity.setMownostDv(dto.getMownostDv());
        entity.setCastotaComp(dto.getCastotaComp());
        entity.setRasxod(dto.getRasxod());
        entity.setRasxodvozd(dto.getRasxodvozd());
        entity.setIzg3(dto.getIzg3());
        entity.setVidMasla(dto.getVidMasla());
        entity.setPlotnost(dto.getPlotnost());
        entity.setObyemBakaKomp(dto.getObyemBakaKomp());
        entity.setObyemBakaDvig(dto.getObyemBakaDvig());
        entity.setVidFiltra(dto.getVidFiltra());
        entity.setCisloFiltra(dto.getCisloFiltra());
        entity.setModelpojSistemi(dto.getModelpojSistemi());
        entity.setVidPoj(dto.getVidPoj());
        entity.setKolVoballonov(dto.getKolVoballonov());
        entity.setVisible(Boolean.TRUE);


        this.gpaRepository.save(entity);

        return dto;
    }
    public List<GPADTO> getAll() {
        List<GPADTO> dtoList = new ArrayList<>();

        List<GPAEntity> entityPage = gpaRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, GPADTO dto) {

        Optional<GPAEntity> optional = gpaRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        GPAEntity entity = new GPAEntity();
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
        entity.setGPA(dto.getGPA());
        entity.setModel(dto.getModel());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setModelKomp(dto.getModelKomp());
        entity.setRascDavlenieKomp(dto.getRascDavlenieKomp());
        entity.setRabDavlenie(dto.getRabDavlenie());
        entity.setPodaca(dto.getPodaca());
        entity.setMownostKomp(dto.getMownostKomp());
        entity.setCastotaDivl(dto.getCastotaDivl());
        entity.setKolVoKolesa(dto.getKolVoKolesa());
        entity.setMayerialKolesa(dto.getMayerialKolesa());
        entity.setVidUplot(dto.getVidUplot());
        entity.setMarkaUplot(dto.getMarkaUplot());
        entity.setIzgotov(dto.getIzgotov());
        entity.setModelDvig(dto.getModelDvig());
        entity.setModelRed(dto.getModelRed());
        entity.setMownostDv(dto.getMownostDv());
        entity.setCastotaComp(dto.getCastotaComp());
        entity.setRasxod(dto.getRasxod());
        entity.setRasxodvozd(dto.getRasxodvozd());
        entity.setIzg3(dto.getIzg3());
        entity.setVidMasla(dto.getVidMasla());
        entity.setPlotnost(dto.getPlotnost());
        entity.setObyemBakaKomp(dto.getObyemBakaKomp());
        entity.setObyemBakaDvig(dto.getObyemBakaDvig());
        entity.setVidFiltra(dto.getVidFiltra());
        entity.setCisloFiltra(dto.getCisloFiltra());
        entity.setModelpojSistemi(dto.getModelpojSistemi());
        entity.setVidPoj(dto.getVidPoj());
        entity.setKolVoballonov(dto.getKolVoballonov());

        this.gpaRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<GPADTO> list() {

        List<GPADTO> dtoList = new ArrayList<>();

        List<GPAEntity> entityPage = gpaRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        GPADTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        gpaRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public GPADTO get(Long id) {

        Optional<GPAEntity> optional = gpaRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public GPADTO toDTO(GPAEntity entity) {

        GPADTO dto = new GPADTO();

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
        dto.setGPA(entity.getGPA());
        dto.setModel(entity.getModel());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setModelKomp(entity.getModelKomp());
        dto.setRascDavlenieKomp(entity.getRascDavlenieKomp());
        dto.setRabDavlenie(entity.getRabDavlenie());
        dto.setPodaca(entity.getPodaca());
        dto.setMownostKomp(entity.getMownostKomp());
        dto.setCastotaDivl(entity.getCastotaDivl());
        dto.setKolVoKolesa(entity.getKolVoKolesa());
        dto.setMayerialKolesa(entity.getMayerialKolesa());
        dto.setVidUplot(entity.getVidUplot());
        dto.setMarkaUplot(entity.getMarkaUplot());
        dto.setIzgotov(entity.getIzgotov());
        dto.setModelDvig(entity.getModelDvig());
        dto.setModelRed(entity.getModelRed());
        dto.setMownostDv(entity.getMownostDv());
        dto.setCastotaComp(entity.getCastotaComp());
        dto.setRasxod(entity.getRasxod());
        dto.setRasxodvozd(entity.getRasxodvozd());
        dto.setIzg3(entity.getIzg3());
        dto.setVidMasla(entity.getVidMasla());
        dto.setPlotnost(entity.getPlotnost());
        dto.setObyemBakaKomp(entity.getObyemBakaKomp());
        dto.setObyemBakaDvig(entity.getObyemBakaDvig());
        dto.setVidFiltra(entity.getVidFiltra());
        dto.setCisloFiltra(entity.getCisloFiltra());
        dto.setModelpojSistemi(entity.getModelpojSistemi());
        dto.setVidPoj(entity.getVidPoj());
        dto.setKolVoballonov(entity.getKolVoballonov());


        return dto;
    }

}
