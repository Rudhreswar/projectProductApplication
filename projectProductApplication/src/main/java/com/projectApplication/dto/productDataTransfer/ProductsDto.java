package com.projectApplication.dto.productDataTransfer;

import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString

public class ProductsDto {

    private Long productCode;

    private String productName;

    private String description;

    // set & get the Values Through Constructor...........................

    public ProductsDto(Long productCode, String productName, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
    }


    // set & get the Values Through the Setters & Getters..........................

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
}
