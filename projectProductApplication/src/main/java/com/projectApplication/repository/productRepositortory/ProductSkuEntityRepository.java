package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.ProductSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSkuEntityRepository extends JpaRepository<ProductSkuEntity, Integer> {
}
