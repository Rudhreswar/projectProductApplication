package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.ProductSkuAPIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSkuAPIEntityRepository extends JpaRepository<ProductSkuAPIEntity, Integer> {
}
