package com.mahroz.kotlin.orderservice.service

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.stereotype.Service

@Service
interface OrderService {

    fun createOrder(orderDto: OrderDto):Unit;
}