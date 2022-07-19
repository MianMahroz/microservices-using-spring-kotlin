package com.mahroz.kotlin.processorservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
class ProcessorServiceApplication

fun main(args: Array<String>) {
	runApplication<ProcessorServiceApplication>(*args)
}
