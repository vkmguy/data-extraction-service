package com.pjait.dataextraction.dataset.config;

import com.pjait.dataextraction.dataset.strategy.impl.TrainTestSplittingStrategy;
import com.pjait.dataextraction.dataset.strategy.SplittingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StrategyConfig {

    @Bean
    @Primary
    public SplittingStrategy trainTestSplittingStrategy() {
        return new TrainTestSplittingStrategy();
    }
}
