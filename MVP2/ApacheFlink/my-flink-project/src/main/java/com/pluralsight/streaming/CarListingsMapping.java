package com.pluralsight.streaming;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.InvalidPropertiesFormatException;

public class CarListingsMapping {

    public static class Car {

        public String make;
        public String model;
        public String type;
        public float price;

        public Car() {
        }

        public Car(String make, String model, String type, float price) {
            this.make = make;
            this.model = model;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Make : " + this.make + ", " + "Model : " + this.model + ", " +
                    "Type : " + this.type + ", " + "Price($) : " + this.price;
        }

    }

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        env.socketTextStream("localhost", 9000)
           .map(new CreateCarObjects())
           .filter(new MakePriceFilter("Ford", 20000f))
        //    Only returning tuple of 3 important attributes  make, model, type. 
           .map(new MapFunction<Car, Tuple3<String, String, String>>() {
               @Override
               public Tuple3<String, String, String> map(Car car) throws Exception {
                   return new Tuple3<>(car.make, car.model, car.type);
               }
           })
        /** Can also do return custom transformed string as an output 
        like we're multiplying the car price with tax amount.**/
        // .map(car -> new Car(car.make, car.model, car.type, car.price * 1.05f))
           .print();

        env.execute();
    }

    public static class CreateCarObjects implements MapFunction<String, Car> {

        @Override
        /* Overriding MapFunction | MapFunction<T, O> |
        T -> Input Type, O -> Output Type, O is Output type */
        public Car map(String carString) throws Exception {

            String[] tokens = carString.split(",");

            if (tokens.length < 4) {
                throw new InvalidPropertiesFormatException("Invalid stream input: " + carString);
            }
            /**
             * Modified Car class to enforce input validation by verifying 
             * stream lengths, throwing an IllegalArgumentException on mismatch.
             * Implemented data transformations for consistency: 
             * whitespace trimming and string-to-float conversion.
             **/
            return new Car(tokens[0].trim(),
                           tokens[1].trim(),
                           tokens[2].trim(),
                           Float.parseFloat(tokens[3].trim()));
        }
    }

    public static class MakePriceFilter implements FilterFunction<Car> {

        private String make;
        private Float price;

        public MakePriceFilter(String make, Float price) {
            this.make = make;
            this.price = price;
        }

        @Override
        public boolean filter(Car car) throws Exception {
            return (car.make).equals(make) && (car.price < price);
        }
    }


}

