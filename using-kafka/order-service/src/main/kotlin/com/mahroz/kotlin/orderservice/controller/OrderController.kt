package com.mahroz.kotlin.orderservice.controller

import com.mahroz.kotlin.kafkaDto.OrderDto
import com.mahroz.kotlin.orderservice.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(val orderService: OrderService) {


    @PostMapping("/saveOrder")
    fun saveOrder(@RequestBody orderDto: OrderDto): ResponseEntity<String> {
        orderService.createOrder(orderDto);
        return ResponseEntity.ok("Order Created successfully")
    }
}