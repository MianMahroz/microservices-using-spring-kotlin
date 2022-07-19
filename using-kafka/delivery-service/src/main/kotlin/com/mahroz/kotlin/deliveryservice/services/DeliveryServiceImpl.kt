package com.mahroz.kotlin.deliveryservice.services

import com.mahroz.kotlin.deliveryservice.util.OrderStatus
import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.stereotype.Service

@Service
class DeliveryServiceImpl : DeliveryService{

    override fun executeDeliveryProcess(order:OrderDto):OrderDto {
        /**
         * Add your delivery service logic here i.e save to db or execute some external service
         */

        order.orderStatus=OrderStatus.SHIPPED;
        return order
    }
}