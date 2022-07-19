package com.mahroz.kotlin.clientservice.consumer

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.apache.kafka.streams.kstream.KStream
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.function.Consumer
import java.util.function.Function
import java.util.logging.Level
import java.util.logging.Logger

@Service
class OrderConsumer {

    var logger: Logger =Logger.getLogger("OrderConsumer");


    /**
     * Order consumer that only consumes data
     */
    @Bean
    fun shippedConsumer():Consumer<KStream<String,OrderDto>>{
        return Consumer<KStream<String,OrderDto>> { kStream->
            kStream.
            foreach { _, order -> logger.log(Level.INFO,"Consumer called ${order.orderStatus}") }
            kStream
        }
    }
}