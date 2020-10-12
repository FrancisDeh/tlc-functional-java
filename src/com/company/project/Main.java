package com.company.project;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        //        Write a function that takes as its argument a String value describing an operation to be
//        carried out
//        on a pair of integers. For example, "add", "subtract", "power".
//        Return a function that will perform the required operation on two Ints,
//        returning an Int result.


        Integer addition = calculate("add", 34, 78);
        Integer subtraction = calculate("subtract", 34, 78);
        Integer power = calculate("power", 34, 78);

        System.out.println("Addition " + addition);
        System.out.println("Subtraction " + subtraction);
        System.out.println("Power " + power);

        //currying in java
        Function<Integer, Function<Integer, Integer>> curryAdd = value -> value2 -> value + value2 + 2;
        System.out.println(curryAdd.apply(5).apply(4));


    }

    public static Integer calculate(String operation, Integer value1, Integer value2) {
        BiFunction<Integer, Integer, Integer> addFunction = Integer::sum;
        BiFunction<Integer, Integer, Integer> subFunction = (val1, val2) -> val1 - val2;
        BiFunction<Integer, Integer, Integer> powFunction = (val1, val2) -> (int) Math.pow(val1, val2);

        return switch (operation) {
            case "add" -> addFunction.apply(value1, value2);
            case "subtract" -> subFunction.apply(value1, value2);
            case "power" -> powFunction.apply(value1, value2);
            default -> 0;
        };
    }


}
