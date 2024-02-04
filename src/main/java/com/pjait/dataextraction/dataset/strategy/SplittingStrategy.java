package com.pjait.dataextraction.dataset.strategy;

import com.pjait.dataextraction.entity.MarketData;

import java.util.List;

public interface SplittingStrategy {

    TrainTestWrapper splitData(List<MarketData> data);
}
