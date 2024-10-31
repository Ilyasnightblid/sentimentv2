package com.socialanalyzer;
import org.apache.spark.ml.feature.CountVectorizerModel;
import org.apache.spark.ml.feature.Tokenizer;
import org.apache.spark.ml.feature.StopWordsRemover;
import org.apache.spark.ml.feature.CountVectorizer;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.ml.classification.NaiveBayes;
import org.apache.spark.ml.classification.NaiveBayesModel;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Sentiment Analysis")
                .master("local[*]")
                .getOrCreate();

        // Call your data processing method here
        processData(spark);
    }

    private static void processData(SparkSession spark) {
        // Read the data (same as above)
        String hdfsPath = "hdfs://localhost:9000/data/training.csv";
        Dataset<Row> data = spark.read()
                .option("header", "true")
                .option("delimiter", ";")
                .csv(hdfsPath);

        // Tokenize the text
        Tokenizer tokenizer = new Tokenizer()
                .setInputCol("text") // Change "text" to your actual column name
                .setOutputCol("words");

        Dataset<Row> tokenizedData = tokenizer.transform(data);

        // Remove stop words
        StopWordsRemover remover = new StopWordsRemover()
                .setInputCol("words")
                .setOutputCol("filtered");

        Dataset<Row> filteredData = remover.transform(tokenizedData);

        // Vectorize the words
        CountVectorizer vectorizer = new CountVectorizer()
                .setInputCol("filtered")
                .setOutputCol("features");

        CountVectorizerModel model = vectorizer.fit(filteredData);
        Dataset<Row> vectorizedData = model.transform(filteredData);

        vectorizedData.show();

        // Train a Naive Bayes model
        NaiveBayes nb = new NaiveBayes()
                .setFeaturesCol("features")
                .setLabelCol("label"); // Change "label" to your actual label column name

        NaiveBayesModel naiveBayesModel = nb.fit(vectorizedData); // Rename variable here

        // Make predictions
        Dataset<Row> predictions = naiveBayesModel.transform(vectorizedData); // Use the renamed variable

        // Evaluate the model
        MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator()
                .setLabelCol("label") // Change "label" to your actual label column name
                .setPredictionCol("prediction")
                .setMetricName("accuracy");

        double accuracy = evaluator.evaluate(predictions);
        System.out.println("Accuracy: " + accuracy);

    }
}
