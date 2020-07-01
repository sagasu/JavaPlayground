package com.github.sagasu.kafka;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerWithCallback {
    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(ProducerWithCallback.class);

        Properties prop = new Properties();
        String servers = "localhost:9092";
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);

        for(int i=0; i < 10;i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello" + Integer.toString(i));

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        logger.info("metadata: \n" + "Topic: " + recordMetadata.topic() + "\n" +
                                "Partition: " + recordMetadata.partition() + "\n" +
                                "Offset: " + recordMetadata.offset() + "\n" +
                                "Timestamp" + recordMetadata.timestamp());
                    } else {
                        logger.error("Error when producing", e);
                    }
                }
            });
        }

        //flush
        producer.flush();

        //flush and close
        producer.close();
    }
}
