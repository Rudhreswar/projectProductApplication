package com.projectApplication.controller;

import com.projectApplication.model.cartModel.CartModel;
import com.projectApplication.model.orderModel.OrderModel;
import com.projectApplication.model.productModel.ProductSkuModel;
import com.projectApplication.model.productModel.ProductsModel;
import com.projectApplication.service.cartService.CartService;
import com.projectApplication.service.fulfilmentService.FulfilmentService;
import com.projectApplication.service.inventoryService.InventoryService;
import com.projectApplication.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class Controller {

    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CartService cartService;

    @Autowired
    private FulfilmentService fulfilmentService;


    //Adding Complete Details for Products..........................................

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public void addProductDetails(@RequestBody ProductsModel productsModel) {

        productService.addProduct(productsModel);

    }

    //Adding Skus details....................................................

    @RequestMapping(value = "/addSkus", method = RequestMethod.POST)
    public void addSkuDetails(@RequestBody ProductSkuModel productSkuModel
            , @PathVariable Long productCode) {
        productService.addingSkuDetails(productSkuModel, productCode);
    }

    //Adding stock (Inventory) details..................................................

    @RequestMapping(value = "/addStock/{skuCode},{quantity}", method = RequestMethod.POST)
    public void addStockDetails(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {

        inventoryService.addingStockValues(skuCode, quantity);
    }

    // CART   -------------------------------------...............

    //add to Cart..............
    @RequestMapping(value = "/addToCart/{skuCode},{quantity}", method = RequestMethod.POST)
    public void addToCart(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {

        cartService.addToCart(skuCode, quantity);

    }

    // VIEW ----CART.........................................
    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public void viewCart() {
        cartService.viewCart();
    }

    // placeOrder...............................
    @RequestMapping(value = "/placeOrder/{skuCode},{quantity}", method = RequestMethod.GET)
    public List<CartModel> placeOrder(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {
        return cartService.viewCart();
    }

    //Get  OrderDetails...........................
    @RequestMapping(value = "/orderDetails/{orderCode}", method = RequestMethod.GET)
    public OrderModel orderDetails(@PathVariable("orderCode") Long orderCode) {
        return cartService.getOrderStatusDetails(orderCode);
    }

    // FULFILMENT-----------------------------------------------------------------
    // Checking the status of the Order.............

    // Processing................
    @RequestMapping(value = "/processing/{orderCode}", method = RequestMethod.GET)
    public String processing(@PathVariable("orderCode") Long orderCode) {

        return fulfilmentService.processing(orderCode);
    }

    // Packing...................
    @RequestMapping(value = "/packing/{orderCode}", method = RequestMethod.GET)
    public String packing(@PathVariable("orderCode") Long orderCode) {
        return fulfilmentService.packing(orderCode);
    }

    // Shipping....................

    @RequestMapping(value = "/shipping/{orderCode}", method = RequestMethod.GET)
    public String shipping(@PathVariable("orderCode") Long orderCode) {

        return fulfilmentService.shipping(orderCode);

    }

    // Delivering..........................
    @RequestMapping(value = "/delivering/{orderCode}", method = RequestMethod.GET)
    public String delivering(@PathVariable("orderCode") Long orderCode) {
        return fulfilmentService.delivering(orderCode);
    }

    // Returning ...........................
    @RequestMapping(value = "/returning/{orderCode}", method = RequestMethod.GET)
    public String returning(@PathVariable("orderCode") Long orderCode) {
        return fulfilmentService.returning(orderCode);
    }


}
