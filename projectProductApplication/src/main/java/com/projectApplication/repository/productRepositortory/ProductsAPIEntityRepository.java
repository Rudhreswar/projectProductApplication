package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.ProductsAPIEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsAPIEntityRepository extends JpaRepository<ProductsAPIEntity,Integer> {
}
