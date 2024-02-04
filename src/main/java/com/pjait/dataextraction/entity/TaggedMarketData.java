package com.pjait.dataextraction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@Table(name = "ml_app_stockdata")
@Getter
@Setter
public class TaggedMarketData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar date;
    private BigDecimal open;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal close;
    private Long volume;
    private Long dividends;
    private Long stock_splits;
    private String tag;

    public TaggedMarketData(MarketData marketData, String tag) {
        this.date = marketData.getDate();
        this.open = marketData.getOpen();
        this.low = marketData.getLow();
        this.high = marketData.getHigh();
        this.close = marketData.getClose();
        this.volume = marketData.getVolume();
        this.dividends = marketData.getDividends();
        this.stock_splits = marketData.getStock_splits();
        this.tag = tag;
    }

    public TaggedMarketData() {
    }
}
