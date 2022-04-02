package com.projectApplication.repository.fulfilmentRepository;

import com.projectApplication.entity.fulfilment.DeliveringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveringEntityRepository extends JpaRepository<DeliveringEntity, Long> {

}
