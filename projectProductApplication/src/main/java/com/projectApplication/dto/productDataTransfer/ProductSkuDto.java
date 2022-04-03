package com.projectApplication.dto.productDataTransfer;


import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString

public class ProductSkuDto {

    private Long skuCode;
    private String size;
    private double price;


    // Set & Get values  Through Constructor  ..........................................

    public ProductSkuDto(Long skuCode, String size, double price) {
        this.skuCode = skuCode;
        this.size = size;
        this.price = price;
    }

    // set and get values  Through getters and setters....................................

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
