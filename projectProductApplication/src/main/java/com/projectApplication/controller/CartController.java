package com.projectApplication.controller;


import com.projectApplication.dto.cartDataTransfer.CartDto;
import com.projectApplication.dto.orderDataTransfer.OrderDto;
import com.projectApplication.service.cartService.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    // CART   -------------------------------------...............

    //add to Cart..............
    @RequestMapping(value = "/addToCart/{skuCode},{quantity}", method = RequestMethod.POST)
    public void addToCart(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {

        cartService.addToCart(skuCode, quantity);

    }

    // VIEW ----CART.........................................
    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public List<CartDto> viewCart() {
        return cartService.viewCart();
    }

    // placeOrder...............................
    @RequestMapping(value = "/placeOrder/{skuCode},{quantity}", method = RequestMethod.GET)
    public String placeOrder(@PathVariable("skuCode") Long skuCode, @PathVariable("quantity") Long quantity) {
        return cartService.placeOrder(skuCode, quantity);
    }

    //Get  OrderDetails...........................
    @RequestMapping(value = "/orderDetails/{orderCode}", method = RequestMethod.GET)
    public OrderDto orderDetails(@PathVariable("orderCode") Long orderCode) {
        return cartService.getOrderDetails(orderCode);
    }
}
