package com.mahroz.kotlin.clientservice.util

enum class OrderStatus(name:String) {
    PENDING("PENDING"),
    INVENTORY_CHECKING("INVENTORY_CHECKING"),
    OUT_OF_STOCK("OUT_OF_STOCK"),
    IN_STOCK("IN_STOCK"),
    SHIPPED("SHIPPED"),
    CANCELED("CANCELED")
}