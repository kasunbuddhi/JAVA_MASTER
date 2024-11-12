package com.one.lambdas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

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

        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Galle City"));

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println("Galle City: " + checkLength.test("Galle City", 8));

        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier Time: " + supTime.get());

        Supplier<Double> supRand = () -> Math.random();
        System.out.println(supRand.get());

        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("Consumer Interface");

        List<String> names = new ArrayList<>();
        names.add("John"); names.add("Mary");
        names.forEach(printC);

        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the Capital of: "+ value);
        mapCapitalCities.forEach(mapPrint);

    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);

    }
}



interface Evaluate<T> {
    boolean isNavigate(T t);
}
