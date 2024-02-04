package com.pjait.dataextraction.dataset.controller;


import com.pjait.dataextraction.dataset.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/strategies")
public class StrategyController {

    private DatasetService datasetService;

    @GetMapping("/trainTestSplit")
    public ResponseEntity<String> trainTestSplit() {
        datasetService.createTrainTestSplit();
        return ResponseEntity.ok(String.format("Tagged Data saved successfully in the Database"));
    }

    @Autowired
    public void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }
}
