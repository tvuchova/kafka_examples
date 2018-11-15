package com.example.demo.kafka_demo_example.config;
/*
 * To create messages, first, we need to configure a ProducerFactory which sets the strategy for creating Kafka
 *Producer instances.
 * Then we need a KafkaTemplate which wraps a Producer instance and provides convenience methods for sending messages to
 * Kafka topics.
 * Producer instances are thread-safe and hence using a single instance throughout an application context will give
 * higher performance. Consequently, KakfaTemplate instances are also thread-safe .
 *
 *
 * */


import com.example.demo.kafka_demo_example.model.KafkaGreeting;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ProducerConfigKafka
{

  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Bean
  public ProducerFactory<String, String> producerFactory()
  {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate()
  {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public ProducerFactory<String, KafkaGreeting> greetingProducerFactory()
  {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, KafkaGreeting> greetingKafkaTemplate()
  {
    return new KafkaTemplate<>(greetingProducerFactory());
  }

}
