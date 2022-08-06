package com.mahroz.kotlin.orderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication

@PropertySource(value = [ "classpath:application.properties" ])
@PropertySource(value = [ "classpath:application.yml" ])
class OrderServiceApplication

fun main(args: Array<String>) {
	runApplication<OrderServiceApplication>(*args)
}
