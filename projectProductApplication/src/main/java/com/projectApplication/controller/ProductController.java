package com.projectApplication.controller;

import com.projectApplication.entity.product.PriceForEachSKUEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.entity.product.ProductsEntity;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Adding Complete Details..........................................
    @PostMapping("/addTotalProDetails")
    public void addDetails(ProductsEntity productsEntity, ProductSkuEntity productSkuEntity,
                           PriceForEachSKUEntity priceForEachSKUEntity) {

        productService.addProductDetails(productsEntity, productSkuEntity, priceForEachSKUEntity);
    }

    //------------------------------------------------------------------------------------------------------------------
    @PostMapping("/product")
    public void addDetails(ProductsEntity productsEntity) {
        productService.addProductDetails(productsEntity);

    }

    @PostMapping("/productSku")
    public void addDetailsSku(ProductSkuEntity productSkuEntity) {
        productService.addProductSkuEntity(productSkuEntity);
    }

    @PostMapping("/productPrice")
    public void addPriceDetails(PriceForEachSKUEntity priceForEachSKUEntity) {
        productService.addPriceForEachSKUDetails(priceForEachSKUEntity);
    }
//--------------------------------------------------------------------------------------------------------------------
}
