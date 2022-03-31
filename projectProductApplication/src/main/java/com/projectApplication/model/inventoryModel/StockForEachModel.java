package com.projectApplication.model.inventoryModel;

import javax.persistence.Id;

public class StockForEachModel {

    @Id
    private String skuCode;
    private int quantityAvailable;
}
