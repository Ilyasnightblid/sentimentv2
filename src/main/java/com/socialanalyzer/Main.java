package com.socialanalyzer;

import com.socialanalyzer.config.HadoopConfig;
import com.socialanalyzer.config.SparkConfig;
import com.socialanalyzer.service.DataCollectorService;
import com.socialanalyzer.service.SentimentAnalyzerService;
import com.socialanalyzer.ui.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.spark.sql.SparkSession;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize configurations
        SparkSession sparkSession = SparkConfig.initializeSparkSession();
        HadoopConfig.initializeHadoopConfig();

        // Initialize services
        DataCollectorService dataCollector = new DataCollectorService();
        SentimentAnalyzerService sentimentAnalyzer = new SentimentAnalyzerService(sparkSession);

        // Launch UI
        MainController mainController = new MainController(dataCollector, sentimentAnalyzer);
        mainController.showMainStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
