package com.mahroz.kotlin.orderservice.service

import com.mahroz.kotlin.kafkaDto.OrderDto
import com.mahroz.kotlin.orderservice.repo.OrderProducer
import com.mahroz.kotlin.orderservice.util.OrderStatus
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(val orderProducer: OrderProducer) : OrderService{

    /**
     * Order logic here i.e save to db and send for further processing
     */
    override fun createOrder(orderDto: OrderDto) {

        orderDto.orderStatus=OrderStatus.INVENTORY_CHECKING;
        orderProducer.sendOrder(orderDto)

    }
}