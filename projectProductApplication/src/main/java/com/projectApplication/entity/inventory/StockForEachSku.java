package com.projectApplication.entity.inventory;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="stock_for_eachSku")
public class StockForEachSku {
    @Id
    @Column(name = "Sku_Code")
    private int skuCode;
    @Column(name="Quantity_Available")
    private int quantityAvailable;
}
