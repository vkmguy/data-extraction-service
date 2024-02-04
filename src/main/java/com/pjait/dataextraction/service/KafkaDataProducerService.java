package com.pjait.dataextraction.service;

import com.pjait.dataextraction.entity.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataProducerService {

    @Value("${kafka.topic.data.name}")
    private String topic;

    private KafkaTemplate<String, MarketData> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, MarketData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MarketData marketData){
        kafkaTemplate.send(topic,marketData);
    }
}
