# REAL TIME ORDER PROBLEM SOLVING USING KAKKA STREAMS

Flow chat for this example is given below. 

## Key Notes
To make kafka instance avaialble plz check kafka-instance directory.
The dto`s that are used by kafka topics should be same all across the application in all microservices in order to serialize and deserialize without error.
Kafka by default uses rocksdb to store stateful data . i.e ktable in our case , where we store the status order state
Here are functions are we commonly use to create KTable: aggregate,count,reduce.

### Client Service
Client service is mainly responsible to directly reading data from Kafka store(kTable) using  **InteractiveQueryService**.                            
It can also reday data from any topic as well using consumer as describe in OrderConsumer.class


### Processor Service
Mainly responsible for filtering and forwarding order stream to related topics

    
    @Bean
    fun orderProcess(): Function<KStream<String, OrderDto>,KStream<String, OrderDto>> {
        return Function<KStream<String, OrderDto>,KStream<String, OrderDto>> { kStream ->

            logger.log(Level.INFO,"Stream of orders received for inventory checking $kStream");
            kStream
                .peek{orderId,order -> logger.log(Level.INFO,"Routing OrderDto $orderId  ${order.orderStatus}") }
                .split()
                .branch(orderTopology.inventoryCheckPredicate, Branched.withConsumer{ks->ks.to(inventoryCheckTopic)})
                .branch(orderTopology.shippingPredicate, Branched.withConsumer{ks->ks.to(deliveryCheckTopic)})
                .branch(orderTopology.unFulfilledOrderPredicate, Branched.withConsumer{ks->ks.to(unFulfilledOrderTopicName)})

            kStream

        }
        





## FLOW DIAGRAM
![order-service-kafka-flow-real-tile](https://user-images.githubusercontent.com/28490692/179777774-4e0057b7-56a4-4158-bbf7-2a3c21ce21bc.png)
