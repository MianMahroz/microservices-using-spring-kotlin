package com.mahroz.kotlin.orderservice.repo

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Repository

/**
 * Kafka producer to send data to order topic for further processing
 */
@Repository
class OrderProducer(val orderProducer:KafkaTemplate<String, OrderDto>) {

    @Value("\${order.topic}")
    private val orderProcessorTopic: String="";

    /**
     * Sending order to order processor
     */
    fun sendOrder(order: OrderDto){
        orderProducer.send(orderProcessorTopic, order.orderId,order);
    }



}