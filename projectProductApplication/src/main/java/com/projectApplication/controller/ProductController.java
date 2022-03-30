package com.projectApplication.controller;

import com.projectApplication.entity.product.ProductsEntity;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/addDetails")
    public void addDetails(ProductsEntity productsEntity) {
        productService.addProductDetails(productsEntity);
    }

    @GetMapping("/get")
    public Iterable<ProductsEntity> getDetail() {
        return productService.getDetails();
    }

}
