package com.pluralsight.streaming;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class LifeExpectancyTracking {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> inputStream =
                env.readTextFile("/Users/karandharmendrapatel/Desktop/MVPS/MVP2/ApacheFlink/my-flink-project/src/main/resources/life_exp.csv");

        DataStream<String> filteredData = inputStream.filter((String value) -> {

            String[] tokens = value.split(",");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            return Double.parseDouble(tokens[3]) >= 75.0;
        });

        filteredData.print();

        env.execute("Filter Country Details");

    }

}

