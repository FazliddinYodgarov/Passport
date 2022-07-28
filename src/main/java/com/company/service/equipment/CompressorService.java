package com.company.service.equipment;

import com.company.dto.ActionDTO;
import com.company.dto.equipments.CompressorDTO;
import com.company.entity.equipments.CompressorEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.equipment.CompressorRepository;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompressorService {
    @Autowired
    private CompressorRepository compressorRepository;
    @Autowired
    private FactoryService factoryService;


    public CompressorDTO create(CompressorDTO dto) {

        CompressorEntity entity = new CompressorEntity();

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
        entity.setEquipmentType(EquipmentType.COMPRESSOR);
        entity.setDavlenie(dto.getDavlenie());
        entity.setProizvoditelnost(dto.getProizvoditelnost());
        entity.setNaIspitaniiDavlenie(dto.getNaIspitaniiDavlenie());
        entity.setPotrebMownost(dto.getPotrebMownost());
        entity.setNapryajenie(dto.getNapryajenie());
        entity.setNapryajenie(dto.getNapryajenie());
        entity.setCastotaVraw(dto.getCastotaVraw());
        entity.setTipPodwipnika(dto.getTipPodwipnika());
        entity.setTipuplot(dto.getTipuplot());
        entity.setPerekacSreda(dto.getPerekacSreda());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setTipdvigatelya(dto.getTipdvigatelya());
        entity.setMarkaDvigatelya(dto.getMarkaDvigatelya());
        entity.setMownostDvigatelya(dto.getMownostDvigatelya());
        entity.setCastotaVraweniya(dto.getCastotaVraweniya());
        entity.setPodwipnikEldv(dto.getPodwipnikEldv());
        entity.setVisible(Boolean.TRUE);

        this.compressorRepository.save(entity);

        return dto;
    }

    public List<CompressorDTO> getAll() {
        List<CompressorDTO> dtoList = new ArrayList<>();

        List<CompressorEntity> entityPage = compressorRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO update(Long id, CompressorDTO dto) {

        Optional<CompressorEntity> optional = compressorRepository.findById(id);


        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Not found id::"+id);
        }
        CompressorEntity entity = new CompressorEntity();
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
        entity.setEquipmentType(EquipmentType.COMPRESSOR);
        entity.setCreatedDate(LocalDate.now());
        entity.setDavlenie(dto.getDavlenie());
        entity.setProizvoditelnost(dto.getProizvoditelnost());
        entity.setNaIspitaniiDavlenie(dto.getNaIspitaniiDavlenie());
        entity.setPotrebMownost(dto.getPotrebMownost());
        entity.setNapryajenie(dto.getNapryajenie());
        entity.setNapryajenie(dto.getNapryajenie());
        entity.setCastotaVraw(dto.getCastotaVraw());
        entity.setTipPodwipnika(dto.getTipPodwipnika());
        entity.setTipuplot(dto.getTipuplot());
        entity.setPerekacSreda(dto.getPerekacSreda());
        entity.setGodVipuska(String.valueOf(dto.getGodVipuska()));
        entity.setRascSrokSlujbi(dto.getRascSrokSlujbi());
        entity.setIzgotovitel(dto.getIzgotovitel());
        entity.setTipdvigatelya(dto.getTipdvigatelya());
        entity.setMarkaDvigatelya(dto.getMarkaDvigatelya());
        entity.setMownostDvigatelya(dto.getMownostDvigatelya());
        entity.setCastotaVraweniya(dto.getCastotaVraweniya());
        entity.setPodwipnikEldv(dto.getPodwipnikEldv());
        this.compressorRepository.save(entity);
        return new ActionDTO(false);
    }

    public List<CompressorDTO> list() {

        List<CompressorDTO> dtoList = new ArrayList<>();

        List<CompressorEntity> entityPage = compressorRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public ActionDTO delete(Long id) {

        CompressorDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        compressorRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public CompressorDTO get(Long id) {

        Optional<CompressorEntity> optional = compressorRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

    public CompressorDTO toDTO(CompressorEntity entity) {

        CompressorDTO dto = new CompressorDTO();

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
        dto.setDavlenie(entity.getDavlenie());
        dto.setProizvoditelnost(entity.getProizvoditelnost());
        dto.setNaIspitaniiDavlenie(entity.getNaIspitaniiDavlenie());
        dto.setPotrebMownost(entity.getPotrebMownost());
        dto.setNapryajenie(entity.getNapryajenie());
        dto.setNapryajenie(entity.getNapryajenie());
        dto.setCastotaVraw(entity.getCastotaVraw());
        dto.setTipPodwipnika(entity.getTipPodwipnika());
        dto.setTipuplot(entity.getTipuplot());
        dto.setPerekacSreda(entity.getPerekacSreda());
        dto.setGodVipuska(entity.getGodVipuska());
        dto.setRascSrokSlujbi(entity.getRascSrokSlujbi());
        dto.setIzgotovitel(entity.getIzgotovitel());
        dto.setTipdvigatelya(entity.getTipdvigatelya());
        dto.setMarkaDvigatelya(entity.getMarkaDvigatelya());
        dto.setMownostDvigatelya(entity.getMownostDvigatelya());
        dto.setCastotaVraweniya(entity.getCastotaVraweniya());
        dto.setPodwipnikEldv(entity.getPodwipnikEldv());
        return dto;
    }

}
