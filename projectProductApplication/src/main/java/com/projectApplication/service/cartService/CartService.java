package com.projectApplication.service.cartService;

import com.projectApplication.entity.cart.CartEntity;
import com.projectApplication.entity.inventory.StockSkuEntity;
import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.model.cartModel.CartModel;
import com.projectApplication.model.orderModel.OrderModel;
import com.projectApplication.repository.InventoryRepository.StockSkuEntityRepository;
import com.projectApplication.repository.cartRepository.CartRepository;
import com.projectApplication.repository.orderRepository.OrderRepository;
import com.projectApplication.repository.productRepositortory.ProductSkuEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockSkuEntityRepository stockSkuEntityRepository;
    @Autowired
    private ProductSkuEntityRepository productSkuEntityRepository;
    @Autowired
    private OrderRepository orderRepository;

    // Checking the inventory is Available and If Available then Add to Cart...............................

    public String addToCart(Long skuCode, Long quantity) {

        Optional<StockSkuEntity> stocksSkuEntityOptional = stockSkuEntityRepository.findById(skuCode);

        // Checking the inventory is Available  or not ..........................
        if (stocksSkuEntityOptional.isPresent()) {
            // Checking the required  Quantity  is Available or not ...........................
            if (stocksSkuEntityOptional.get().getQuantityAvailable() >= quantity) {

                CartEntity cartEntityObj = new CartEntity();
                cartEntityObj.setSkuCode(skuCode);
                cartEntityObj.setQuantity(quantity);
                cartEntityObj.setProductSkuEntityCart(stocksSkuEntityOptional.get()
                        .getProductSkuEntityInStock());

                cartRepository.save(cartEntityObj);

                return "Items Added to your Cart Successfully ";

            } else {
                return "Required  Quantity is not Available  in Stock";
            }

        } else {
            return "Out Of Stock";
        }
    }

    //   API to view cart........................................................................

    public List<CartModel> viewCart() {

        List<CartEntity> cartEntityList = cartRepository.findAll();

        double[] total = {0.0};
        List<CartModel> cartModelList = cartEntityList.stream().map(cart -> {

            //Total Amount for selected Items....................................................
            total[0] += cart.getQuantity() * cart.getProductSkuEntityCart().getProductSkuEntity().getPrice();

            //Generating complete details ........................................................

            CartModel cartModelObj = new CartModel();

            cartModelObj.setProductCode(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getProductCode());
            cartModelObj.setProductName(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getProductName());
            cartModelObj.setDescription(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getDescription());
            cartModelObj.setSkuCode(cart.getSkuCode());
            cartModelObj.setSize(cart.getProductSkuEntityCart().getSize());
            cartModelObj.setOrderCode(cart.getCartCode());
            cartModelObj.setPrice(cart.getProductSkuEntityCart()
                    .getProductSkuEntity()
                    .getPrice());
            cartModelObj.setQuantity(cart.getQuantity());
            cartModelObj.setTotal(total[0]);


            return cartModelObj;
        }).collect(Collectors.toList());

        return cartModelList;
    }
//---------------------------------------------------------------------------------------------------------------------------

    // API to place order....-----------------------------------------------------------.................


    private String placeOrder(Long skuCode, Long quantity) {

        /* This API should verify if inventory is available or not. .*/


        Optional<StockSkuEntity> stockSkuEntityOptional = stockSkuEntityRepository.findById(skuCode);

        // Check the item is present or not................
        if (stockSkuEntityOptional.isPresent()) {

            // Checking the quantity of Items are available or not  in Repository.............................................
            if (stockSkuEntityOptional.get().getQuantityAvailable() >= quantity) {

                OrderEntity orderEntityObj = new OrderEntity();
                orderEntityObj.setStatus("Received");
                orderEntityObj.setQuantity(quantity);

                orderEntityObj.setCartEntityOrder(stockSkuEntityOptional.get()
                        .getOrderEntity()
                        .getCartEntityOrder());
                orderEntityObj.setStockSkuEntityOrder(stockSkuEntityOptional.get()
                        .getProductSkuEntityInStock()
                        .getStockSkuEntity());

                orderRepository.save(orderEntityObj);

                //Updating stock by removing Ordered Items .......................................
                // Update Stock ................when Order is placed ...................

                stockSkuEntityOptional.get()
                        .setQuantityAvailable(stockSkuEntityOptional.get().getQuantityAvailable() - quantity);

                stockSkuEntityRepository.save(stockSkuEntityOptional.get());

                //--------------we have to write logic to Once order is placed - inventory should be reduced....----------------

                Optional<ProductSkuEntity> productSkuEntityOptional = productSkuEntityRepository.findById(skuCode);

                return "Ordered Successfully Placed";
            }
            return "Out OF Stock ";
        }

        return "This Item is not Exist  ";
    }

    // Get OrderStatus.........................................................................

    public OrderModel getOrderStatusDetails(Long orderCode) {

        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            OrderModel orderModel = new OrderModel();
            orderModel.setProductCode(optionalOrderEntity.get().getOrderCode());
            orderModel.setProductName(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductsEntitySku()
                    .getProductName());
            orderModel.setOrderCode(optionalOrderEntity.get().getOrderCode());
            orderModel.setDescription(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductsEntitySku()
                    .getDescription());
            orderModel.setSkuCode(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getSkuCode());
            orderModel.setOrderCode(optionalOrderEntity.get()
                    .getOrderCode());
            orderModel.setPrice(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductSkuEntity()
                    .getPrice());

            orderModel.setQuantity(optionalOrderEntity.get().getQuantity());


            return orderModel;

        }


        return null;
    }


}
