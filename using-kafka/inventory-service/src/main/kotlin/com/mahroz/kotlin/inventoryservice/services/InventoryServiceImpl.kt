package com.mahroz.kotlin.inventoryservice.services

import com.mahroz.kotlin.kafkaDto.OrderDto
import com.mahroz.kotlin.inventoryservice.util.OrderStatus
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class InventoryServiceImpl:InventoryService {

    var logger: Logger = Logger.getLogger("InventoryServiceImpl");

    /**
     * Return true if order id is less than 100
     * You can write you own logic i.e check product inventory from Database
     */
    override fun checkingInventory(order: OrderDto): OrderDto {
        if(order.orderId.toLong()<100){
            logger.log(Level.INFO,"STOCK AVAILABLE ${order.orderId}")
            order.orderStatus=OrderStatus.IN_STOCK;
        }else{
            logger.log(Level.INFO,"OUT OF STOCK AVAILABLE ${order.orderId}")
            order.orderStatus=OrderStatus.OUT_OF_STOCK;
        }
        return order
    }
}