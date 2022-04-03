package com.projectApplication.dto.cartDataTransfer;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString

public class CartDto {
    private Long productCode;
    private String productName;
    private String description;
    private Long skuCode;
    private String size;
    private Long orderCode;
    private double price;
    private Long quantity;
    private double total;

    // Constructor....................................................
    public CartDto(Long productCode, String productName,
                   String description, Long skuCode, String size,
                   Long orderCode, double price, Long quantity, double total) {
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.skuCode = skuCode;
        this.size = size;
        this.orderCode = orderCode;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    //Setters and Getter................................................

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}