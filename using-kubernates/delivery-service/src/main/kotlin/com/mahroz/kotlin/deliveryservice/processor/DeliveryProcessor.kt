package com.mahroz.kotlin.deliveryservice.processor

import com.mahroz.kotlin.deliveryservice.services.DeliveryService
import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.apache.kafka.streams.kstream.*
import java.util.function.Consumer
import java.util.logging.Level
import java.util.logging.Logger
import java.util.function.Function
@Service
class DeliveryProcessor(val deliveryService: DeliveryService) {

    var logger: Logger =Logger.getLogger("DeliveryProcessor");


    /**
     * Takes real time order stream and execute delivery business rules
     * return the updated stream that then update the stateful store(kTable).
     */
    @Bean
    fun deliveryProcess(): Function<KStream<String, OrderDto>, KStream<String, OrderDto>> {
        return Function<KStream<String, OrderDto>, KStream<String, OrderDto>> { kStream ->
            kStream
                .peek{_,v->logger.log(Level.INFO,"Executing Delivery Process ${v.orderStatus}")}
                .mapValues { v-> deliveryService.executeDeliveryProcess(v) }

            kStream
        }
    }

}