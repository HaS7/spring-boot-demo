package com.spring.demo.mq;

public class RabbitMqUtils {

    public static final String DIRECT_EXCHANGE = "demo.direct.exchange";

    public static final String FANOUT_EXCHANGE = "demo.fanout.exchange";

    public static final String TOPIC_EXCHANGE = "demo.topic.exchange";

    public static final String DURABLE_QUEUE = "demo.queue.durable";

    public static final String NOT_DURABLE_QUEUE = "demo.queue.not.durable";

    public static final String TopRoutingKey = "demo.topic.#";

    public static final String DirectRoutingKey = "demo.direct";
}
