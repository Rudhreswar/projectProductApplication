package com.projectApplication.controller;

import com.projectApplication.dto.productDataTransfer.ProductSkuDto;
import com.projectApplication.dto.productDataTransfer.ProductsDto;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Adding Complete Details for Products..........................................

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public String addProductDetails(@RequestBody ProductsDto productsDto) {

        productService.addProduct(productsDto);

        return "Product Added Successfully";
    }

    //Adding Skus details....................................................

    @RequestMapping(value = "/{productCode}/addSkus", method = RequestMethod.POST)
    public String addSkuDetails(
            @PathVariable("productCode") Long productCode, @RequestBody ProductSkuDto productSkuDto) {
        productService.addingSkuDetails(productCode, productSkuDto);
        return "Sku added Successfully";
    }


}
