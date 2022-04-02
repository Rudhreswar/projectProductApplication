package com.projectApplication.entity.cart;

import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.entity.product.ProductSkuEntity;

import javax.persistence.*;

@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartCode;
    private Long skuCode;
    private Long quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductSkuEntity productSkuEntityCart;

    @OneToOne(mappedBy = "cartEntityOrder", cascade = CascadeType.ALL)
    private OrderEntity orderEntityCart;

    public OrderEntity getOrderEntityCart() {
        return orderEntityCart;
    }

    public void setOrderEntityCart(OrderEntity orderEntityCart) {
        this.orderEntityCart = orderEntityCart;
    }

    public Long getCartCode() {
        return cartCode;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
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
