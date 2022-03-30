package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsEntityRepository extends JpaRepository<ProductsEntity,Long> {
}
