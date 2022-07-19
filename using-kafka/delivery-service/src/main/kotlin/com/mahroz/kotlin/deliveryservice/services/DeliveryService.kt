package com.mahroz.kotlin.deliveryservice.services

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.stereotype.Service

@Service
interface DeliveryService {

    fun executeDeliveryProcess(orderDto: OrderDto):OrderDto;

}