package com.projectApplication.controller;

import com.projectApplication.entity.product.ProductsAPIEntity;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addDetails")
    public void addDetails(ProductsAPIEntity productsAPIEntity) {
        productService.adddetails(productsAPIEntity);
    }
}
