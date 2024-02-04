package com.pjait.dataextraction.dataset.strategy.impl;

import com.pjait.dataextraction.dataset.strategy.SplittingStrategy;
import com.pjait.dataextraction.dataset.strategy.TrainTestWrapper;
import com.pjait.dataextraction.entity.MarketData;

import java.util.ArrayList;
import java.util.List;

public class TrainTestSplittingStrategy implements SplittingStrategy {
    @Override
    public TrainTestWrapper splitData(List<MarketData> data) {
        // Define the split ratio
        double trainRatio = 0.8; // 80% for training, 20% for testing

        // Calculate split points
        int totalSize = data.size();
        int trainSize = (int) (totalSize * trainRatio);

        // Create datasets
        List<MarketData> trainingSet = new ArrayList<>(data.subList(0, trainSize));
        List<MarketData> testingSet = new ArrayList<>(data.subList(trainSize, totalSize));

        return new TrainTestWrapper(trainingSet, testingSet);
    }
}
