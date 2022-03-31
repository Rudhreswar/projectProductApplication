package com.projectApplication.entity.inventory;


import com.projectApplication.entity.product.ProductSkuEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "stock_for_eachSku")
public class StockForEachSkuEntity {
    @Id
    @Column(name = "Sku_Code")
    private String skuCode;
    @Column(name = "Quantity_Available")
    private int quantityAvailable;


    @OneToOne
    private ProductSkuEntity productSkuEntityInStock;

}
