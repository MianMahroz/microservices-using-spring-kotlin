package com.mahroz.kotlin.inventoryservice.processor

import com.mahroz.kotlin.kafkaDto.OrderDto
import com.mahroz.kotlin.inventoryservice.services.InventoryService
import org.springframework.stereotype.Service
import org.apache.kafka.streams.kstream.*
import org.springframework.context.annotation.Bean
import java.util.function.Function
import java.util.logging.Level
import java.util.logging.Logger

@Service
class InventoryCheckProcessor(val inventoryService: InventoryService) {

    var logger: Logger =Logger.getLogger("InventoryCheckProcessor");

    /**
     * Takes OrderDto stream as passed by order process  and apply inventory business logic
     */
    @Bean
    fun inventoryCheck(): Function<KStream<String, OrderDto>,KStream<String, OrderDto>> {
        return Function<KStream<String, OrderDto>, KStream<String, OrderDto>> { kStream ->
            kStream
                .peek{_,v->logger.log(Level.INFO,"Applying Inventory Checking Process ${v.orderStatus}")}
                .mapValues { v-> inventoryService.checkingInventory(v) }

            kStream
        }
    }

}