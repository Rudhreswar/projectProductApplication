package com.projectApplication.service.productService;


import com.projectApplication.entity.product.ProductsAPIEntity;
import com.projectApplication.repository.productRepositortory.PriceForEachSKUEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductSkuAPIEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductsAPIEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ProductService {

    @Autowired
    private ProductSkuAPIEntityRepository productSkuAPIEntityRepository;
    @Autowired
    private PriceForEachSKUEntityRepository priceForEachSKUEntityRepository;
    @Autowired
    private ProductsAPIEntityRepository productsAPIEntityRepository;


    // Adding Products Api Entity....................


    public void adddetails(ProductsAPIEntity productsAPIEntity) {


     //   LinkedList<ProductsAPIEntity> productsAPIEntityLinkedList = new LinkedList<>();

        ProductsAPIEntity productsAPIEntitiesObj = new ProductsAPIEntity();
        productsAPIEntitiesObj.setProductCode(productsAPIEntity.getProductCode());
        productsAPIEntitiesObj.setProductName(productsAPIEntity.getProductName());
        productsAPIEntitiesObj.setDescription(productsAPIEntity.getDescription());
        productsAPIEntitiesObj.setProductSkuAPIEntities(productsAPIEntity.getProductSkuAPIEntities());
        productsAPIEntitiesObj.setPriceForEachSKUEntities(productsAPIEntity.getPriceForEachSKUEntities());

        productsAPIEntityRepository.save(productsAPIEntitiesObj);


    }
}
