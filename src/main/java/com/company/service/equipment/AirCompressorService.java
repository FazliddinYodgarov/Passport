package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.AirCompressorDTO;
import com.company.dto.equipments.ExchangerDTO;
import com.company.entity.equipments.AirCompressorEntity;
import com.company.entity.equipments.ExchangerEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.AirCompressorRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirCompressorService {

    @Autowired
    private AirCompressorRepository airCompressorRepository;
    @Autowired
    private FactoryService factoryService;


    public AirCompressorDTO create(AirCompressorDTO dto) {

        AirCompressorEntity entity = new AirCompressorEntity();
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
        entity.setEquipmentType(EquipmentType.AIR_COMPRESSOR);
        entity.setProizvoditelnost(dto.getProizvoditelnost());
        entity.setRabSreda(dto.getRabSreda());
        entity.setCastotaVraw(dto.getCastotaVraw());
        entity.setDavlNaVxode(dto.getDavlNaVxode());
        entity.setDavlNaVixode(dto.getDavlNaVixode());
        entity.setRabTempNaVxode(dto.getRabTempNaVxode());
        entity.setRabTempNaVixode(dto.getRabTempNaVixode());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setTipUplot(dto.getTipUplot());
        entity.setModelUplot(dto.getModelUplot());
        entity.setIzgotovitelUplot(dto.getIzgotovitelUplot());
        entity.setTipReduktora(dto.getTipReduktora());
        entity.setModelReduktora(dto.getModelReduktora());
        entity.setZavodskoyNomer2(dto.getZavodskoyNomer2());
        entity.setRegNomer2(dto.getRegNomer2());
        entity.setKolVo(dto.getKolVo());
        entity.setCastotaVrawenia(dto.getCastotaVrawenia());
        entity.setCisloPeredac(dto.getCisloPeredac());
        entity.setIzgotovitelReduktora(dto.getIzgotovitelReduktora());
        entity.setGodVipuskaReduk(dto.getGodVipuskaReduk());
        entity.setTipPodwip(dto.getTipPodwip());
        entity.setNaimTurbini(dto.getNaimTurbini());
        entity.setModelTurbini(dto.getModelTurbini());
        entity.setZavodskoyNomer6(dto.getZavodskoyNomer6());
        entity.setRegNomer7(dto.getRegNomer7());
        entity.setCastVraweniaTurb(dto.getCastVraweniaTurb());
        entity.setMownost(dto.getMownost());
        entity.setTipPodwipnikov9(dto.getTipPodwipnikov9());
        entity.setIzgotovitelTurbini(dto.getIzgotovitelTurbini());
        entity.setGodVipuska10(dto.getGodVipuska10());
        entity.setMarkaMasla(dto.getMarkaMasla());
        entity.setObyem(dto.getObyem());
        entity.setVisible(Boolean.TRUE);

       this.airCompressorRepository.save(entity);

        return dto;
    }


    public List<AirCompressorDTO> getAll() {
        List<AirCompressorDTO> dtoList = new ArrayList<>();

        List<AirCompressorEntity> entityPage = airCompressorRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }
    public ActionDTO update(Long id, AirCompressorDTO dto) {

        Optional<AirCompressorEntity> optional = airCompressorRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        AirCompressorEntity entity = new AirCompressorEntity();
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
        entity.setEquipmentType(EquipmentType.AIR_COMPRESSOR);
        entity.setCreatedDate(LocalDate.now());
        entity.setProizvoditelnost(dto.getProizvoditelnost());
        entity.setRabSreda(dto.getRabSreda());
        entity.setCastotaVraw(dto.getCastotaVraw());
        entity.setDavlNaVxode(dto.getDavlNaVxode());
        entity.setDavlNaVixode(dto.getDavlNaVixode());
        entity.setRabTempNaVxode(dto.getRabTempNaVxode());
        entity.setRabTempNaVixode(dto.getRabTempNaVixode());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setGodVipuska(dto.getGodVipuska());
        entity.setDataVvoda(dto.getDataVvoda());
        entity.setRascSrok(dto.getRascSrok());
        entity.setTipUplot(dto.getTipUplot());
        entity.setModelUplot(dto.getModelUplot());
        entity.setIzgotovitelUplot(dto.getIzgotovitelUplot());
        entity.setTipReduktora(dto.getTipReduktora());
        entity.setModelReduktora(dto.getModelReduktora());
        entity.setZavodskoyNomer2(dto.getZavodskoyNomer2());
        entity.setRegNomer2(dto.getRegNomer2());
        entity.setKolVo(dto.getKolVo());
        entity.setCastotaVrawenia(dto.getCastotaVrawenia());
        entity.setCisloPeredac(dto.getCisloPeredac());
        entity.setIzgotovitelReduktora(dto.getIzgotovitelReduktora());
        entity.setGodVipuskaReduk(dto.getGodVipuskaReduk());
        entity.setTipPodwip(dto.getTipPodwip());
        entity.setNaimTurbini(dto.getNaimTurbini());
        entity.setModelTurbini(dto.getModelTurbini());
        entity.setZavodskoyNomer6(dto.getZavodskoyNomer6());
        entity.setRegNomer7(dto.getRegNomer7());
        entity.setCastVraweniaTurb(dto.getCastVraweniaTurb());
        entity.setMownost(dto.getMownost());
        entity.setTipPodwipnikov9(dto.getTipPodwipnikov9());
        entity.setIzgotovitelTurbini(dto.getIzgotovitelTurbini());
        entity.setGodVipuska10(dto.getGodVipuska10());
        entity.setMarkaMasla(dto.getMarkaMasla());
        entity.setObyem(dto.getObyem());

        this.airCompressorRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<AirCompressorDTO> list() {

        List<AirCompressorDTO> dtoList = new ArrayList<>();

        List<AirCompressorEntity> entityPage = airCompressorRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        AirCompressorDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        airCompressorRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public AirCompressorDTO get(Long id) {

        Optional<AirCompressorEntity> optional = airCompressorRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not Found id::" +id);
        }

        return toDTO(optional.get());
    }

    public AirCompressorDTO toDTO(AirCompressorEntity entity) {

        AirCompressorDTO dto = new AirCompressorDTO();
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
        dto.setProizvoditelnost(entity.getProizvoditelnost());
        dto.setRabSreda(entity.getRabSreda());
        dto.setCastotaVraw(entity.getCastotaVraw());
        dto.setDavlNaVxode(entity.getDavlNaVxode());
        dto.setDavlNaVixode(entity.getDavlNaVixode());
        dto.setRabTempNaVxode(entity.getRabTempNaVxode());
        dto.setRabTempNaVixode(entity.getRabTempNaVixode());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setDataVvoda(entity.getDataVvoda());
        dto.setRascSrok(entity.getRascSrok());
        dto.setTipUplot(entity.getTipUplot());
        dto.setModelUplot(entity.getModelUplot());
        dto.setIzgotovitelUplot(entity.getIzgotovitelUplot());
        dto.setTipReduktora(entity.getTipReduktora());
        dto.setModelReduktora(entity.getModelReduktora());
        dto.setZavodskoyNomer2(entity.getZavodskoyNomer2());
        dto.setRegNomer2(entity.getRegNomer2());
        dto.setKolVo(entity.getKolVo());
        dto.setCastotaVrawenia(entity.getCastotaVrawenia());
        dto.setCisloPeredac(entity.getCisloPeredac());
        dto.setIzgotovitelReduktora(entity.getIzgotovitelReduktora());
        dto.setGodVipuskaReduk(entity.getGodVipuskaReduk());
        dto.setTipPodwip(entity.getTipPodwip());
        dto.setNaimTurbini(entity.getNaimTurbini());
        dto.setModelTurbini(entity.getModelTurbini());
        dto.setZavodskoyNomer6(entity.getZavodskoyNomer6());
        dto.setRegNomer7(entity.getRegNomer7());
        dto.setCastVraweniaTurb(entity.getCastVraweniaTurb());
        dto.setMownost(entity.getMownost());
        dto.setTipPodwipnikov9(entity.getTipPodwipnikov9());
        dto.setIzgotovitelTurbini(entity.getIzgotovitelTurbini());
        dto.setGodVipuska10(entity.getGodVipuska10());
        dto.setMarkaMasla(entity.getMarkaMasla());



        return dto;
    }
}
