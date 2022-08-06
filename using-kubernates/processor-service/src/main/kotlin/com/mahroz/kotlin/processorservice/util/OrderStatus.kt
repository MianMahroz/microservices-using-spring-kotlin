package com.mahroz.kotlin.processorservice.util

enum class OrderStatus(name:String) {
    PENDING("PENDING"),
    INVENTORY_CHECKING("INVENTORY_CHECKING"),
    IN_STOCK("IN_STOCK"),
    OUT_OF_STOCK("OUT_OF_STOCK"),
    SHIPPED("SHIPPED"),
    CANCELED("CANCELED")
}