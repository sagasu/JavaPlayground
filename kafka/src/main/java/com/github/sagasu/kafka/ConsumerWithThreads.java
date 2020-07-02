package com.github.sagasu.kafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerWithThreads {
    public static void main(String[] args) {



        String bootstrapServer = "127.0.0.1:9092";
        String groupId = "my-app";
        String topic = "first_topic";


        CountDownLatch latch = new CountDownLatch(1);
        Runnable consumerThread = new ConsumerThread(bootstrapServer, groupId, topic, latch);

    }

    public class ConsumerThread implements Runnable {
        CountDownLatch latch;
        private String topic;
        KafkaConsumer<String, String> consumer;
        Logger logger = LoggerFactory.getLogger(ConsumerThread.class.getName());
        public ConsumerThread(String bootstrapServer,
                              String groupId,
                              String topic,
                              CountDownLatch latch){
            this.latch = latch;
            this.topic = topic;
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            consumer = new KafkaConsumer<String, String>(properties);
            //multiple topics
            consumer.subscribe(Arrays.asList(topic, "second_topic"));
        }

        @Override
        public void run(){
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                    for (ConsumerRecord<String, String> record : records) {
                        logger.info("key: " + record.key() + ", value: " + record.value());
                        logger.info("partition: " + record.partition() + ", offset: " + record.offset());
                    }
                }
            }catch (WakeupException e){
                logger.info("Received shutdown signal!", e);
            }finally {
                consumer.close();
                latch.countDown();
            }
        }

        public void shutdown(){
            consumer.wakeup();
        }
    }
}
