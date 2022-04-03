package com.projectApplication.service.productService;


import com.projectApplication.entity.product.PriceForEachSkuEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.entity.product.ProductsEntity;
import com.projectApplication.dto.productDataTransfer.ProductSkuDto;
import com.projectApplication.dto.productDataTransfer.ProductsDto;
import com.projectApplication.repository.productRepositortory.PriceForEachSkuEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductSkuEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductsEntityRepository productsEntityRepository;
    @Autowired
    private ProductSkuEntityRepository productSkuEntityRepository;
    @Autowired
    private PriceForEachSkuEntityRepository priceForEachSKUEntityRepository;


    // Adding Product Details........................
    public void addProduct(ProductsDto productsDto) {
        ProductsEntity productsEntityObj = new ProductsEntity();
        productsEntityObj.setProductName(productsDto.getProductName());
        productsEntityObj.setDescription(productsDto.getDescription());

        productsEntityRepository.save(productsEntityObj);
    }

    // Adding Sku details ...........................
    public void addingSkuDetails(ProductSkuDto productSkuDto, Long productCode) {
        Optional<ProductsEntity> productsEntityOptional = productsEntityRepository.findById(productCode);

        if (productsEntityOptional.isPresent()) {
            productsEntityOptional.stream().forEach(product -> {

                        ProductSkuEntity productSkuEntityObj = new ProductSkuEntity();
                        productSkuEntityObj.setProductsEntitySku(product);
                        productSkuEntityObj.setSize(productSkuDto.getSize());

                        //Saving Sku data to repository.......................
                        productSkuEntityRepository.save(productSkuEntityObj);

                        PriceForEachSkuEntity priceForEachSkuEntityObj = new PriceForEachSkuEntity();
                        priceForEachSkuEntityObj.setProductSkuEntityPrice(productSkuEntityObj);
                        priceForEachSkuEntityObj.setPrice(productSkuDto.getPrice());


                    }
            );
        }
    }
}
