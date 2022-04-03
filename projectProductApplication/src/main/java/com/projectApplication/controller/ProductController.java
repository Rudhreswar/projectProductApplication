package com.projectApplication.controller;

import com.projectApplication.dto.productDataTransfer.ProductSkuDto;
import com.projectApplication.dto.productDataTransfer.ProductsDto;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class ProductController {

    @Autowired
    private ProductService productService;

    //Adding Complete Details for Products..........................................

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public void addProductDetails(@RequestBody ProductsDto productsDto) {

        productService.addProduct(productsDto);

    }

    //Adding Skus details....................................................

    @RequestMapping(value = "/addSkus", method = RequestMethod.POST)
    public void addSkuDetails(@RequestBody ProductSkuDto productSkuDto
            , @PathVariable Long productCode) {
        productService.addingSkuDetails(productSkuDto, productCode);
    }


}
