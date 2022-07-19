package com.mahroz.kotlin.inventoryservice.services

import com.mahroz.kotlin.kafkaDto.OrderDto
import org.springframework.stereotype.Service

@Service
interface InventoryService {

    fun checkingInventory(order: OrderDto): OrderDto;
}