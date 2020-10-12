package com.company.project;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(performFunctionalCalculations("add", 1, 2));
        System.out.println(performFunctionalCalculations("multiply", 1, 2));
        System.out.println(performFunctionalCalculations("power", 1, 2));
    }

    public static Integer performFunctionalCalculations(String operation, int value1, int value2) {
        BiFunction<Integer, Integer, Integer> operationFunction;
        Integer result = 0;
        // (i, t) -> i + t; sum
        switch (operation.toLowerCase()) {
            case "add" -> {
                operationFunction = Integer::sum;
                result = operationFunction.apply(value1, value2);
            }
            case "multiply" -> {
                operationFunction = (i, t) -> i * t;
                result = operationFunction.apply(value1, value2);
            }
            case "power" -> {
                operationFunction = (i, t) -> (int) Math.pow(i, t);
                result = operationFunction.apply(value1, value2);
            }
        }

        return result;
    }
}
