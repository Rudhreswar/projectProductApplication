package com.projectApplication.entity.cart;

import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.entity.product.ProductSkuEntity;

import javax.persistence.*;

@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartCode;
    private Long quantity;

    @OneToOne
    private ProductSkuEntity productSkuEntityCart;


    public Long getCartCode() {
        return cartCode;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ProductSkuEntity getProductSkuEntityCart() {
        return productSkuEntityCart;
    }

    public void setProductSkuEntityCart(ProductSkuEntity productSkuEntityCart) {
        this.productSkuEntityCart = productSkuEntityCart;
    }
}
