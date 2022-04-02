package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.PriceForEachSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceForEachSkuEntityRepository extends JpaRepository<PriceForEachSkuEntity, Long> {
}
