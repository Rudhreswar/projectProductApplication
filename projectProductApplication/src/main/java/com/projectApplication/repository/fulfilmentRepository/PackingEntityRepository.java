package com.projectApplication.repository.fulfilmentRepository;


import com.projectApplication.entity.fulfilment.PackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingEntityRepository extends JpaRepository<PackingEntity,Long> {
}
