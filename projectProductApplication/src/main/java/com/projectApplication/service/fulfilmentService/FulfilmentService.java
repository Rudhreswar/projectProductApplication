package com.projectApplication.service.fulfilmentService;

import com.projectApplication.entity.fulfilment.*;
import com.projectApplication.entity.order.OrderEntity;
import com.projectApplication.dto.orderDataTransfer.OrderDto;
import com.projectApplication.repository.fulfilmentRepository.*;
import com.projectApplication.repository.orderRepository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FulfilmentService {
    @Autowired
    private DeliveringEntityRepository deliveringEntityRepository;
    @Autowired
    private PackingEntityRepository packingEntityRepository;
    @Autowired
    private ProductionEntityRepository productionEntityRepository;
    @Autowired
    private ReturningEntityRepository returningEntityRepository;

    @Autowired
    private ShippingEntityRepository shippingEntityRepository;

    @Autowired
    private OrderRepository orderRepository;


    // Processing the fulfilment Processing request...........

    //Received to processing............................

    public String processing(Long orderCode) {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            if (optionalOrderEntity.get().getStatus().equalsIgnoreCase("Received")) {
                optionalOrderEntity.get().setStatus("Processing");

                orderRepository.save(optionalOrderEntity.get());
                ProcessingEntity processingEntityObj = new ProcessingEntity();
                productionEntityRepository.save(processingEntityObj);
                OrderDto orderDto = new OrderDto();
                orderDto.setQuantity(optionalOrderEntity.get().getQuantity());
                orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
                orderDto.setPrice(optionalOrderEntity.get().getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getProductSkuEntity()
                        .getPrice());
                orderDto.setDescription(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getDescription());
                orderDto.setSkuCode(optionalOrderEntity.get().getStockSkuEntityOrder().getSkuCode());
                orderDto.setProductName(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getProductName());
                orderDto.setProductCode(optionalOrderEntity.get()
                        .getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getProductsEntitySku()
                        .getProductCode());


                return "YOUR ORDER IS PROCESSING............................!";
            }
            return "UNABLE TO PROCESS YOUR ORDER";
        }
        return "THE PRODUCT WITH THIS ORDER CODE : " + optionalOrderEntity.get().getOrderCode() + "DOES NOT EXISTS.";
    }

    //--------------------------------------------------------------------------------------------------------

    //Processing to Packing........................................

    public String packing(Long orderCode) {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            if (optionalOrderEntity.get().getStatus().equalsIgnoreCase("processing")) {
                optionalOrderEntity.get().setStatus("Packing");
                orderRepository.save(optionalOrderEntity.get());
                PackingEntity packingEntityObj = new PackingEntity();
                packingEntityRepository.save(packingEntityObj);
                OrderDto orderDto = new OrderDto();
                orderDto.setQuantity(optionalOrderEntity.get().getQuantity());
                orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
                orderDto.setPrice(optionalOrderEntity.get().getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getProductSkuEntity()
                        .getPrice());
                orderDto.setDescription(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getDescription());
                orderDto.setSkuCode(optionalOrderEntity.get().getStockSkuEntityOrder().getSkuCode());
                orderDto.setProductName(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getProductName());
                orderDto.setProductCode(optionalOrderEntity.get()
                        .getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getProductsEntitySku()
                        .getProductCode());

                return "YOUR ODER IS PACKING.........!";
            }
            return "UNABLE TO PACK YOUR ORDER";
        }
        return "THE PRODUCT WITH THIS ORDER CODE : " + optionalOrderEntity.get()
                .getOrderCode() + "DOES NOT EXISTS.";
    }

    //Packing to Shipping,..........................................

    public String shipping(Long orderCode) {


        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            if (optionalOrderEntity.get().getStatus().equalsIgnoreCase("packing")) {
                optionalOrderEntity.get().setStatus("shipping");
                orderRepository.save(optionalOrderEntity.get());
                ShippingEntity shippingEntity = new ShippingEntity();

                shippingEntityRepository.save(shippingEntity);
                OrderDto orderDto = new OrderDto();
                orderDto.setQuantity(optionalOrderEntity.get().getQuantity());
                orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
                orderDto.setPrice(optionalOrderEntity.get().getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getProductSkuEntity()
                        .getPrice());
                orderDto.setDescription(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getDescription());
                orderDto.setSkuCode(optionalOrderEntity.get().getStockSkuEntityOrder().getSkuCode());
                orderDto.setProductName(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getProductName());
                orderDto.setProductCode(optionalOrderEntity.get()
                        .getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getProductsEntitySku()
                        .getProductCode());

                return "YOUR ORDER IS SHIPPING..........";
            }
            return "Unable ship your ORDER ";
        }
        return "THE PRODUCT WITH THIS ORDER CODE : " + optionalOrderEntity.get().getOrderCode() + "DOES NOT EXISTS.";
    }

    // Shipping to Delivering.....................................................

    public String delivering(Long orderCode) {


        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            if (optionalOrderEntity.get().getStatus().equalsIgnoreCase("shipping")) {
                optionalOrderEntity.get().setStatus("delivered");
                orderRepository.save(optionalOrderEntity.get());
                DeliveringEntity deliveringEntityObj = new DeliveringEntity();

                deliveringEntityRepository.save(deliveringEntityObj);
                OrderDto orderDto = new OrderDto();
                orderDto.setQuantity(optionalOrderEntity.get().getQuantity());
                orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
                orderDto.setPrice(optionalOrderEntity.get().getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getProductSkuEntity()
                        .getPrice());
                orderDto.setDescription(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getDescription());
                orderDto.setSkuCode(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getSkuCode());
                orderDto.setProductName(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getProductName());
                orderDto.setProductCode(optionalOrderEntity.get()
                        .getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getProductsEntitySku()
                        .getProductCode());

                return " YOUR ORDER IS DELIVERING..............";
            }
            return "ORDER IS NOT ABLE TO DELIVER";
        }
        return "THE PRODUCT WITH THIS ORDER CODE : " + optionalOrderEntity.get().getOrderCode() + "DOES NOT EXISTS.";
    }

    //Delivered to returned.............................

    public String returning(Long orderCode) {

        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderCode);

        if (optionalOrderEntity.isPresent()) {
            if (optionalOrderEntity.get().getStatus().equalsIgnoreCase("delivered")) {
                optionalOrderEntity.get().setStatus("returning");
                orderRepository.save(optionalOrderEntity.get());

                ReturningEntity returningEntityObj = new ReturningEntity();

                returningEntityRepository.save(returningEntityObj);
                OrderDto orderDto = new OrderDto();
                orderDto.setQuantity(optionalOrderEntity.get().getQuantity());
                orderDto.setOrderCode(optionalOrderEntity.get().getOrderCode());
                orderDto.setPrice(optionalOrderEntity.get().getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getCartEntityInSku()
                        .getProductSkuEntityCart()
                        .getProductSkuEntity()
                        .getPrice());
                orderDto.setDescription(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getDescription());
                orderDto.setSkuCode(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getSkuCode());
                orderDto.setProductName(optionalOrderEntity.get()
                        .getStockSkuEntityOrder()
                        .getProductSkuEntityInStock()
                        .getProductsEntitySku()
                        .getProductName());
                orderDto.setProductCode(optionalOrderEntity.get()
                        .getCartEntityOrder()
                        .getProductSkuEntityCart()
                        .getProductsEntitySku()
                        .getProductCode());

                return "YOUR ORDER HAS RETURNED............";
            }
            return "UNABLE TO RETURN THE ORDER";
        }
        return "THE PRODUCT WITH THIS ORDER CODE : " + optionalOrderEntity.get().getOrderCode() + "DOES NOT EXISTS.";
    }
}
