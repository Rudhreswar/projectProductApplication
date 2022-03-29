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

public class ProductSkuAPIModel {
    @Id
    private int skuCode;
    private int productCode;
    private int size;
}
