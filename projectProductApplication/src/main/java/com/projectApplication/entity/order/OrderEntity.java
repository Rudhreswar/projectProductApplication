package com.projectApplication.entity.order;

import com.projectApplication.entity.cart.CartEntity;
import com.projectApplication.entity.inventory.StockSkuEntity;

import javax.persistence.*;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;
    private String status;
    private Long quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private StockSkuEntity stockSkuEntityOrder;

    @OneToOne(cascade = CascadeType.ALL)
    private CartEntity cartEntityOrder;

    public CartEntity getCartEntityOrder() {
        return cartEntityOrder;
    }

    public void setCartEntityOrder(CartEntity cartEntityOrder) {
        this.cartEntityOrder = cartEntityOrder;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public StockSkuEntity getStockSkuEntityOrder() {
        return stockSkuEntityOrder;
    }

    public void setStockSkuEntityOrder(StockSkuEntity stockSkuEntityOrder) {
        this.stockSkuEntityOrder = stockSkuEntityOrder;
    }
}
