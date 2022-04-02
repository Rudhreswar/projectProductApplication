package com.projectApplication.repository.fulfilmentRepository;

import com.projectApplication.entity.fulfilment.ProcessingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionEntityRepository extends JpaRepository<ProcessingEntity, Long> {

}
