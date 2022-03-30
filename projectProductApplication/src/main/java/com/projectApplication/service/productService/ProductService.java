package com.projectApplication.service.productService;


import com.projectApplication.entity.product.PriceForEachSKUEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.entity.product.ProductsEntity;
import com.projectApplication.repository.productRepositortory.PriceForEachSKUEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductSkuEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductSkuEntityRepository productSkuEntityRepository;
    @Autowired
    private PriceForEachSKUEntityRepository priceForEachSKUEntityRepository;
    @Autowired
    private ProductsEntityRepository productsEntityRepository;


    // Adding Product Details.........................

    public void addProductDetails(ProductsEntity productsEntity) {

        ProductsEntity productsAPIEntitiesObj = new ProductsEntity();
        productsAPIEntitiesObj.setProductCode(productsEntity.getProductCode());
        productsAPIEntitiesObj.setProductName(productsEntity.getProductName());
        productsAPIEntitiesObj.setDescription(productsEntity.getDescription());

        productsEntityRepository.save(productsAPIEntitiesObj);
    }

    // Adding Price details for each Sku..........................................................

    public void addPriceForEachSKUDetails(PriceForEachSKUEntity priceForEachSKUEntity) {
        PriceForEachSKUEntity priceForEachSKUEntityObj = new PriceForEachSKUEntity();
        priceForEachSKUEntityObj.setSkuCode(priceForEachSKUEntity.getSkuCode());
        priceForEachSKUEntityObj.setPrice(priceForEachSKUEntity.getPrice());

        //Saving the details into the repository......................
        priceForEachSKUEntityRepository.save(priceForEachSKUEntity);

    }

    // Adding Products Skus ..................................
    public void addProductSkuEntity(ProductSkuEntity productSkuEntity) {
        ProductSkuEntity productSkuEntityObj = new ProductSkuEntity();
        productSkuEntityObj.setProductCode(productSkuEntity.getProductCode());
        productSkuEntityObj.setSkuCode(productSkuEntity.getSkuCode());
        productSkuEntityObj.setSize(productSkuEntity.getSize());

        //Saving the details into the repository......................
        productSkuEntityRepository.save(productSkuEntity);
    }

    // Getting all details of Product details...........................

    public Iterable<ProductsEntity> getDetails() {
        return productsEntityRepository.findAll();
    }


}
