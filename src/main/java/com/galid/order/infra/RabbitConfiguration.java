package com.galid.order.infra;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    private static final String QUEUE_NAME = "order";
    private static final String TOPIC_EXCHANGE_NAME = "order-exchange";


}
