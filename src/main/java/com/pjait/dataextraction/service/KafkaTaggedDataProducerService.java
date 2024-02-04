package com.pjait.dataextraction.service;

import com.pjait.dataextraction.entity.TaggedMarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTaggedDataProducerService {

    @Value("${kafka.topic.taggedData.name}")
    private String topic;

    private KafkaTemplate<String, TaggedMarketData> kafkaTaggedDataTemplate;

    @Autowired
    public void setKafkaTaggedDataTemplate(KafkaTemplate<String, TaggedMarketData> kafkaTaggedDataTemplate) {
        this.kafkaTaggedDataTemplate = kafkaTaggedDataTemplate;
    }

    public void sendMessage(TaggedMarketData marketData){
        kafkaTaggedDataTemplate.send(topic,marketData);
    }
}
