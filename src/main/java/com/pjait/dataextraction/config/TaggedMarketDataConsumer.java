package com.pjait.dataextraction.config;

import com.pjait.dataextraction.entity.MarketData;
import com.pjait.dataextraction.entity.TaggedMarketData;
import com.pjait.dataextraction.service.MarketDataService;
import com.pjait.dataextraction.service.TaggedMarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TaggedMarketDataConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaggedMarketDataConsumer.class);

    private TaggedMarketDataService taggedMarketDataService;

    @Autowired
    public void setDataRepository(TaggedMarketDataService marketDataService) {
        this.taggedMarketDataService = marketDataService;
    }

    @KafkaListener(topics = "market-db-tagged-data-topic", groupId = "market-data", containerFactory = "taggedMarketDataListener")
    public void consume(TaggedMarketData marketData) {
            taggedMarketDataService.saveMarketData(marketData);
    }
}

