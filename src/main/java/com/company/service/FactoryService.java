package com.company.service;


import com.company.dto.ActionDTO;
import com.company.dto.FactoryDTO;
import com.company.entity.FactoryEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FactoryService {


    @Autowired
    private FactoryRepository factoryRepository;



    public FactoryDTO create(FactoryDTO dto){

        FactoryEntity entity=new FactoryEntity();
        entity.setFactoryName(dto.getFactoryName());
        entity.setCreatedDate(LocalDateTime.now());
        factoryRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
    public List<FactoryDTO> getAll() {

        return factoryRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ActionDTO delete(Long id) {
        FactoryDTO dto = get(id);

        if (Optional.ofNullable(dto).isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        factoryRepository.deleteById(id);

        return new ActionDTO(false);
    }


    public FactoryDTO get(Long id) {

        Optional<FactoryEntity> optional = factoryRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return toDTO(optional.get());
    }

//    public FactoryDTO update(Long id, FactoryDTO dto) {
//
//        Optional<FactoryEntity> optional = factoryRepository.findById(id);
//
//        FactoryEntity entity = optional.get();
//        entity.setFactoryName(dto.getFactoryName());
//        factoryRepository.save(entity);
//        return toDTO(entity);
//    }
    public ActionDTO update(Long id, FactoryDTO dto) {

        Optional<FactoryEntity> optional = factoryRepository.findById(id);

        if (optional.isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }
        FactoryEntity entity = optional.get();
        entity.setFactoryName(dto.getFactoryName());
        factoryRepository.save(entity);
        return new ActionDTO(false);
    }


    public FactoryDTO toDTO(FactoryEntity entity) {
        FactoryDTO dto = new FactoryDTO();
        dto.setId(entity.getId());
        dto.setFactoryName(entity.getFactoryName());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public FactoryDTO toDTO(Long id, String name) {
        FactoryDTO dto = new FactoryDTO();
        dto.setId(id);
        dto.setFactoryName(name);
        return dto;
    }


}
