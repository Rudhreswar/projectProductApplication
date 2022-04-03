package com.projectApplication.dto.inventoryDataTransfer;


import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString

public class StockSkuDto {


    private Long skuCode;
    private Long quantityAvailable;

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
