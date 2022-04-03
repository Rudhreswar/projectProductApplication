package com.projectApplication.controller;

import com.projectApplication.service.fulfilmentService.FulfilmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FulfillmentController {
    @Autowired
    private FulfilmentService fulfilmentService;


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