package com.xiaour.spring.boot.kafka.consumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerSimple {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inStream = KafkaProducerSimple.class.getClassLoader().getResourceAsStream("producer.properties");

        properties.load(inStream);

        Producer<String, String> producer = new KafkaProducer<>(properties);
        String TOPIC = "orderMq6";
        for (int messageNo = 1; messageNo < 10000; messageNo++) {
            producer.send(new ProducerRecord<String, String>(TOPIC,messageNo + "", UUID.randomUUID() + "itcast"));
        }
    }
}
