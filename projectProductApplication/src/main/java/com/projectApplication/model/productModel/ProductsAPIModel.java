package com.projectApplication.model.productModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductsAPIModel {
    @Id

    private int productCode;

    private String productName;

    private String description;


}
