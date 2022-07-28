package com.company.repository.equipment;

import com.company.entity.equipments.PipelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PipelineRepository extends JpaRepository<PipelineEntity,Long> {
}
