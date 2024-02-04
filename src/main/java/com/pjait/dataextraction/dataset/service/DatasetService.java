package com.pjait.dataextraction.dataset.service;

import com.pjait.dataextraction.dao.MarketDataRepository;
import com.pjait.dataextraction.dao.TaggedMarketDataRepository;
import com.pjait.dataextraction.dataset.strategy.SplittingStrategy;
import com.pjait.dataextraction.dataset.strategy.TrainTestWrapper;
import com.pjait.dataextraction.entity.MarketData;
import com.pjait.dataextraction.entity.TaggedMarketData;
import com.pjait.dataextraction.service.KafkaTaggedDataProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetService {
    private MarketDataRepository marketDataRepository;

    private TaggedMarketDataRepository taggedMarketDataRepository;

    private SplittingStrategy trainTestSplittingStrategy;

    private KafkaTaggedDataProducerService kafkaTaggedDataProducerService;

    public void createTrainTestSplit() {
        truncateTaggedDataTable();
        List<MarketData> dataPoints = fetchData();
        TrainTestWrapper splitData = trainTestSplittingStrategy.splitData(dataPoints);
        splitData.getTestData().stream()
                .map(x -> new TaggedMarketData(x, "TEST"))
                .forEach(data -> kafkaTaggedDataProducerService.sendMessage(data));

        splitData.getTrainData().stream()
                .map(x -> new TaggedMarketData(x, "TRAIN"))
                .forEach(data -> kafkaTaggedDataProducerService.sendMessage(data));
    }

    private List<MarketData> fetchData() {
        return marketDataRepository.findAll();
    }

    private void truncateTaggedDataTable() {
        taggedMarketDataRepository.deleteAll();
    }

    @Autowired
    public void setMarketDataRepository(MarketDataRepository marketDataRepository) {
        this.marketDataRepository = marketDataRepository;
    }

    @Autowired
    public void setTaggedMarketDataRepository(TaggedMarketDataRepository taggedMarketDataRepository) {
        this.taggedMarketDataRepository = taggedMarketDataRepository;
    }

    @Autowired
    public void setTrainTestSplittingStrategy(SplittingStrategy trainTestSplittingStrategy) {
        this.trainTestSplittingStrategy = trainTestSplittingStrategy;
    }

    @Autowired
    public void setKafkaProducerService(KafkaTaggedDataProducerService kafkaTaggedDataProducerService) {
        this.kafkaTaggedDataProducerService = kafkaTaggedDataProducerService;
    }
}
