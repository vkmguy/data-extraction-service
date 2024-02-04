package com.pjait.dataextraction.dataset.strategy;

import com.pjait.dataextraction.entity.MarketData;

import java.util.List;

public class TrainTestWrapper {

    List<MarketData> trainData;
    List<MarketData> testData;

    public TrainTestWrapper(List<MarketData> trainData, List<MarketData> testData) {
        this.trainData = trainData;
        this.testData = testData;
    }

    public List<MarketData> getTrainData() {
        return trainData;
    }

    public List<MarketData> getTestData() {
        return testData;
    }
}
