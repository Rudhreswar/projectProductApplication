package com.projectApplication.entity.inventory;


import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@ToString

@Entity
public class StockSkuEntity {
    @Id
    private Long skuCode;
    private Long quantityAvailable;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductSkuEntity productSkuEntityInStock;

    @OneToOne(mappedBy = "stockSkuEntityOrder", cascade = CascadeType.ALL)
    private OrderEntity orderEntity;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public Long getSkuCode() {
        return skuCode;
    }


    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public ProductSkuEntity getProductSkuEntityInStock() {
        return productSkuEntityInStock;
    }

    public void setProductSkuEntityInStock(ProductSkuEntity productSkuEntityInStock) {
        this.productSkuEntityInStock = productSkuEntityInStock;
    }

}
