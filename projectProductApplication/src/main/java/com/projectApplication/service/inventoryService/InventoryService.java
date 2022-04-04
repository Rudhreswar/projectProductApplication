package com.projectApplication.service.inventoryService;

import com.projectApplication.entity.inventory.StockSkuEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.repository.InventoryRepository.StockSkuEntityRepository;
import com.projectApplication.repository.productRepositortory.ProductSkuEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private StockSkuEntityRepository stockSkuEntityRepository;
    @Autowired
    private ProductSkuEntityRepository productSkuEntityRepository;

    public String addingStockValues(Long skuCode, Long quantityAdd) {
        Optional<ProductSkuEntity> productSkuEntityOptional = productSkuEntityRepository.findById(skuCode);

        if (productSkuEntityOptional.isPresent()) {

            StockSkuEntity stockSkuEntityObj = new StockSkuEntity();
            stockSkuEntityObj.setSkuCode(skuCode);
            stockSkuEntityObj.setQuantityAvailable(quantityAdd);
            stockSkuEntityObj.setProductSkuEntityInStock(productSkuEntityOptional.get());

            stockSkuEntityRepository.save(stockSkuEntityObj);

            return "Stock Added Successfully for the Given skuCode";
        } else {
            return "Kindly enter the Correct SkuCode ";
        }


    }

    public String updateStock(Long skuCode, Long quantity) {
        Optional<StockSkuEntity> stockSkuEntityOptional = stockSkuEntityRepository.findById(skuCode);

        if (stockSkuEntityOptional.isPresent()) {
            stockSkuEntityOptional.get().setQuantityAvailable(stockSkuEntityOptional.get().getQuantityAvailable() + quantity);

            stockSkuEntityRepository.save(stockSkuEntityOptional.get());
            return "Stock updated Successfully";
        }
        return "Required Sku is not Available";
    }

}
