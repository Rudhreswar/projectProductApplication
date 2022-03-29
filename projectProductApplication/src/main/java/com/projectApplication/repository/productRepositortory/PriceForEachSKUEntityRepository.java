package com.projectApplication.repository.productRepositortory;

import com.projectApplication.entity.product.PriceForEachSKUEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceForEachSKUEntityRepository extends JpaRepository<PriceForEachSKUEntity, Long> {
}
