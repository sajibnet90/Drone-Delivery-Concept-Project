package com.bridgingcode.springbootactivemqdemo.publisher.controller;

import com.bridgingcode.springbootactivemqdemo.model.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    // @Autowired
    // private JmsTemplate jmsTemplate;

    // @PostMapping("/pizza/orders")
    // public ResponseEntity<String> publishPizzaOrder(@RequestBody orders pizzaOrder) {
    //     try {
    //         jmsTemplate.convertAndSend("pizza-order-queue", pizzaOrder);
    //         return new ResponseEntity<>("Pizza order sent.", HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}
