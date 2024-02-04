package com.pjait.dataextraction.service;

import com.pjait.dataextraction.dao.MarketDataRepository;
import com.pjait.dataextraction.dao.TaggedMarketDataRepository;
import com.pjait.dataextraction.entity.MarketData;
import com.pjait.dataextraction.entity.TaggedMarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaggedMarketDataService {
    private TaggedMarketDataRepository repository;

    @Autowired
    public void setRepository(TaggedMarketDataRepository repository) {
        this.repository = repository;
    }

    public void saveMarketData(TaggedMarketData marketData) {
        repository.save(marketData);
    }
}
