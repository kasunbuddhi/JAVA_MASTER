package com.one.lambdas;

import java.util.function.Predicate;

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNavigate(-1));
        System.out.println("Evaluate: " + lambda.isNavigate(+1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        Evaluate<Integer> lambda2 = i -> { return i < 0;};
        System.out.println("Evaluate: " + lambda2.isNavigate(-1));
        System.out.println("Evaluate: " + lambda2.isNavigate(+1));
    }
}

interface Evaluate<T> {
    boolean isNavigate(T t);
}
