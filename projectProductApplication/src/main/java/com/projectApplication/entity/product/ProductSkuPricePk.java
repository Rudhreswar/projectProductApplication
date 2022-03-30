package com.projectApplication.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Embeddable
public class ProductSkuPricePk implements Serializable {

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "products_id")
    private ProductsEntity productsEntity;





}
