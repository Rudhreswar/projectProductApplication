package com.projectApplication.controller;

import com.projectApplication.service.inventoryService.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    //Adding stock (Inventory) details..................................................

    @RequestMapping(value = "/addStock/{skuCode},{quantity}", method = RequestMethod.POST)
    public String addStockDetails(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {

        return inventoryService.addingStockValues(skuCode, quantity);
    }

    @RequestMapping(value = "/updateStock/{skuCode},{quantity}", method = RequestMethod.PUT)
    public String updateStock(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {
        return inventoryService.updateStock(skuCode, quantity);
    }
}
