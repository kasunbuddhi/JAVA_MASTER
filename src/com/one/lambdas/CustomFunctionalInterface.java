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

        int x = 4;
        System.out.println("Is " + x + "even?"+ check(x, n -> n%2 == 0));
        x = 7;
        System.out.println("Is " + x + "even?"+ check(x, n -> n%2 == 0));

        String name = "Mr. Virat Kohli";
        System.out.println("Does " + name + "Starts with Mr.?"+ check(name, n -> n.startsWith("Mr.")));

        name = "Ms. Anushka Sharma";
        System.out.println("Does " + name + "Starts with Mr.?"+ check(name, n -> n.startsWith("Mr.")));
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);

    }
}



interface Evaluate<T> {
    boolean isNavigate(T t);
}
