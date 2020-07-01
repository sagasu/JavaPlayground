package com.github.sagasu.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerWithKeys {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Logger logger = LoggerFactory.getLogger(ProducerWithKeys.class);

        Properties prop = new Properties();
        String servers = "localhost:9092";
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);

        for(int i=0; i < 10;i++) {
            String topic = "first_topic";
            String val = "hello" + Integer.toString(i);
            String key = "id_" + Integer.toString(i);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,key, val);

            logger.info("key " + key);
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
            }).get(); // nasty, don't force async to act as sync, crappy performance
        }

        //flush
        producer.flush();

        //flush and close
        producer.close();
    }
}
