package com.projectApplication.service.productService;


import com.projectApplication.entity.product.PriceForEachSkuEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.entity.product.ProductsEntity;
import com.projectApplication.model.productModel.ProductSkuModel;
import com.projectApplication.model.productModel.ProductsModel;
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
    public void addProduct(ProductsModel productsModel) {
        ProductsEntity productsEntityObj = new ProductsEntity();
        productsEntityObj.setProductName(productsModel.getProductName());
        productsEntityObj.setDescription(productsModel.getDescription());

        productsEntityRepository.save(productsEntityObj);
    }

    // Adding Sku details ...........................
    public void addingSkuDetails(ProductSkuModel productSkuModel, Long productCode) {
        Optional<ProductsEntity> productsEntityOptional = productsEntityRepository.findById(productCode);

        if (productsEntityOptional.isPresent()) {
            productsEntityOptional.stream().forEach(product -> {

                        ProductSkuEntity productSkuEntityObj = new ProductSkuEntity();
                        productSkuEntityObj.setProductsEntitySku(product);
                        productSkuEntityObj.setSize(productSkuModel.getSize());

                        //Saving Sku data to repository.......................
                        productSkuEntityRepository.save(productSkuEntityObj);

                        PriceForEachSkuEntity priceForEachSkuEntityObj = new PriceForEachSkuEntity();
                        priceForEachSkuEntityObj.setProductSkuEntityPrice(productSkuEntityObj);
                        priceForEachSkuEntityObj.setPrice(productSkuModel.getPrice());


                    }
            );
        }
    }
}
