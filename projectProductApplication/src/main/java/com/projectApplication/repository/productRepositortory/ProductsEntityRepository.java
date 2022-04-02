package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsEntityRepository extends JpaRepository<ProductsEntity,Long> {
}
