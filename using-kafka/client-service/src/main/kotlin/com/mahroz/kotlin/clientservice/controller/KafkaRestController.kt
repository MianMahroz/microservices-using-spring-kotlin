package com.mahroz.kotlin.clientservice.controller

import org.apache.kafka.streams.state.QueryableStoreTypes
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaRestController(val interactiveQueryService: InteractiveQueryService) {

    @Value("\${order.store.name}")
    var orderStoreName:String="";


    /**
     * Takes orderId and query stateful kafka store (kTable) for data
     */
    @GetMapping("status/{orderId}")
    fun getOrderCurrentStatus(@PathVariable(name="orderId")  orderId:String):ResponseEntity<String>{
        var store:ReadOnlyKeyValueStore<String, String> = interactiveQueryService.getQueryableStore(orderStoreName, QueryableStoreTypes.keyValueStore());
        return ResponseEntity.ok(store.get(orderId));
    }
}