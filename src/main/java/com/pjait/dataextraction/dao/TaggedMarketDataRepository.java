package com.pjait.dataextraction.dao;

import com.pjait.dataextraction.entity.MarketData;
import com.pjait.dataextraction.entity.TaggedMarketData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaggedMarketDataRepository extends JpaRepository<TaggedMarketData, Long> {

}
