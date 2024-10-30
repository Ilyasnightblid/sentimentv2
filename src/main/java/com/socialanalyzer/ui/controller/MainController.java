package com.socialanalyzer.ui.controller;

import com.socialanalyzer.service.DataCollectorService;
import com.socialanalyzer.service.SentimentAnalyzerService;
import javafx.stage.Stage;

public class MainController {

    private final DataCollectorService dataCollectorService;
    private final SentimentAnalyzerService sentimentAnalyzerService;

    public MainController(DataCollectorService dataCollectorService, SentimentAnalyzerService sentimentAnalyzerService) {
        this.dataCollectorService = dataCollectorService;
        this.sentimentAnalyzerService = sentimentAnalyzerService;
    }

    public void showMainStage(Stage stage) {
        // Code to display the main stage
    }
}

