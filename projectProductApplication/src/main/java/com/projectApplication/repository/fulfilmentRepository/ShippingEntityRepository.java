package com.projectApplication.repository.fulfilmentRepository;


import com.projectApplication.entity.fulfilment.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingEntityRepository extends JpaRepository<ShippingEntity, Long> {

}
