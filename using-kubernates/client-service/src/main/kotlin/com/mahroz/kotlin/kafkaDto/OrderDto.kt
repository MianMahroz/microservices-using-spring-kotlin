package com.mahroz.kotlin.kafkaDto

import com.mahroz.kotlin.clientservice.util.OrderStatus

class OrderDto(var orderId:String, var productName:String, var orderStatus:OrderStatus) {
}