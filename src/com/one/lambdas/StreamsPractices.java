package com.one.lambdas;

import java.util.Arrays;
import java.util.List;

public class StreamsPractices {
    public static void main(String[] args) {
        List<Double> temps = Arrays.asList(98.6, 100.2, 87.9, 102.8);
        System.out.println("Nuymbers of temps > is: " +
                temps
                        .stream()
                        .peek(System.out::println)
                        .filter(temp -> temp > 100)
                        .peek(System.out::println)
                        .count()
        );
    }
}
