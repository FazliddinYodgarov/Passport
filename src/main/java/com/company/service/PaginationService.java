package com.company.service;

import com.company.dto.Paged;
import com.company.dto.Paging;
import com.company.entity.equipments.ExchangerEntity;
import com.company.mapper.EquipmentGeneralInfo;
import com.company.repository.equipment.EquipmentGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.Sort.Direction.ASC;
@Service
public class PaginationService {

    private EquipmentGeneralRepository equipmentGeneralRepository;

    @Autowired
    public PaginationService(EquipmentGeneralRepository equipmentGeneralRepository) {
        this.equipmentGeneralRepository = equipmentGeneralRepository;
    }
    public Paged<ExchangerEntity> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size,  Sort.by(ASC,"id"));
        Page<ExchangerEntity> postPage = equipmentGeneralRepository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }

}
