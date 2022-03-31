package com.projectApplication.repository.InventoryRepository;

import com.projectApplication.entity.inventory.StockForEachSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockForEackSkuEntityRepository extends JpaRepository<StockForEachSkuEntity, String> {

}
