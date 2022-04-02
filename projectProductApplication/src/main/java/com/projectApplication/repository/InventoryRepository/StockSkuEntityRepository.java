package com.projectApplication.repository.InventoryRepository;

import com.projectApplication.entity.inventory.StockSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockSkuEntityRepository extends JpaRepository<StockSkuEntity, Long> {

}
