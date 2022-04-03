package com.projectApplication.service.cartService;

import com.projectApplication.entity.cart.CartEntity;
import com.projectApplication.entity.inventory.StockSkuEntity;
import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.entity.product.ProductSkuEntity;
import com.projectApplication.dto.cartDataTransfer.CartDto;
import com.projectApplication.dto.orderDataTransfer.OrderDto;
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
    public CartRepository cartRepository;
    @Autowired
    public StockSkuEntityRepository stockSkuEntityRepository;
    @Autowired
    public ProductSkuEntityRepository productSkuEntityRepository;
    @Autowired
    public OrderRepository orderRepository;

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

    public List<CartDto> viewCart() {

        List<CartEntity> cartEntityList = cartRepository.findAll();

        double[] total = {0.0};
        List<CartDto> cartDtoList = cartEntityList.stream().map(cart -> {

            //Total Amount for selected Items....................................................
            total[0] += cart.getQuantity() * cart.getProductSkuEntityCart().getProductSkuEntity().getPrice();

            //Generating complete details ........................................................

            CartDto cartDtoObj = new CartDto();

            cartDtoObj.setProductCode(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getProductCode());
            cartDtoObj.setProductName(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getProductName());
            cartDtoObj.setDescription(cart.getProductSkuEntityCart()
                    .getProductsEntitySku()
                    .getDescription());
            cartDtoObj.setSkuCode(cart.getSkuCode());
            cartDtoObj.setSize(cart.getProductSkuEntityCart().getSize());
            cartDtoObj.setOrderCode(cart.getCartCode());
            cartDtoObj.setPrice(cart.getProductSkuEntityCart()
                    .getProductSkuEntity()
                    .getPrice());
            cartDtoObj.setQuantity(cart.getQuantity());
            cartDtoObj.setTotal(total[0]);


            return cartDtoObj;
        }).collect(Collectors.toList());

        return cartDtoList;
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
            } else {
                return "Required Quantity is not Available ";
            }
        }
        return "Out of Stock ";
    }

    // Get OrderStatus.........................................................................

    public OrderDto getOrderStatusDetails(Long orderCode) {

        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            OrderDto orderDto = new OrderDto();
            orderDto.setProductCode(optionalOrderEntity.get().getOrderCode());
            orderDto.setProductName(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductsEntitySku()
                    .getProductName());
            orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
            orderDto.setDescription(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductsEntitySku()
                    .getDescription());
            orderDto.setSkuCode(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getSkuCode());
            orderDto.setOrderCode(optionalOrderEntity.get()
                    .getOrderCode());
            orderDto.setPrice(optionalOrderEntity.get()
                    .getStockSkuEntityOrder()
                    .getProductSkuEntityInStock()
                    .getProductSkuEntity()
                    .getPrice());

            orderDto.setQuantity(optionalOrderEntity.get().getQuantity());


            return orderDto;

        }


        return null;
    }


}
