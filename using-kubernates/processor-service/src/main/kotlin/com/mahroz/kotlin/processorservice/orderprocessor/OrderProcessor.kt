package com.mahroz.kotlin.processorservice.orderprocessor

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.apache.kafka.streams.kstream.KStream
import org.springframework.stereotype.Service
import org.apache.kafka.streams.kstream.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import java.util.function.Function
import java.util.logging.Level
import java.util.logging.Logger

@Service
class OrderProcessor(val orderTopology: OrderTopology) {

    var logger: Logger =Logger.getLogger("OrderServiceImpl");


    @Value("\${inventory-topic-name}")
    var inventoryCheckTopic:String="";

    @Value("\${shipping-topic-name}")
    var deliveryCheckTopic:String="";

    @Value("\${unfulfilled-orders-topic-name}")
    var unFulfilledOrderTopicName:String="";

    /**
     * Tables order stream , split stream by order status and send to related topics using branch.
     */
    @Bean
    fun orderProcess(): Function<KStream<String, OrderDto>,KStream<String, OrderDto>> {
        return Function<KStream<String, OrderDto>,KStream<String, OrderDto>> { kStream ->

            logger.log(Level.INFO,"Stream of orders received for inventory checking $kStream");
            kStream
                .peek{orderId,order -> logger.log(Level.INFO,"Routing OrderDto $orderId  ${order.orderStatus}") }
                .split()
                .branch(orderTopology.inventoryCheckPredicate, Branched.withConsumer{ks->ks.to(inventoryCheckTopic)})
                .branch(orderTopology.shippingPredicate, Branched.withConsumer{ks->ks.to(deliveryCheckTopic)})
                .branch(orderTopology.unFulfilledOrderPredicate, Branched.withConsumer{ks->ks.to(unFulfilledOrderTopicName)})

            kStream

        }
    }
}