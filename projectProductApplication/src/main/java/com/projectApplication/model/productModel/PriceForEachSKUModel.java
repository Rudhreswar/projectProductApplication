package com.projectApplication.model.productModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

//-api to add price for each sku
//      -> database fields - skucode, price

public class PriceForEachSKUModel {
    @Id
    private long skuCode;
    private double price;
    //cart-->cartId,OrderCode,proSkucode,quantity,orderStatus
}
