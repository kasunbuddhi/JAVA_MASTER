package com.one.lambdas;

import java.time.LocalTime;
import java.util.*;
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

        Function<String, Integer> fn = s -> s.length();
        System.out.println("Function: " + fn.apply("Moscow"));

        BiFunction<String, String, Integer> biFn = (s1,s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespear"));

        BiFunction<String, String, String> biFn2 = (s1,s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William ", "Shakespear"));

        UnaryOperator<String> unaryOp = name1 -> "My Name is " + name1;
        System.out.println("UnaryOperator: " + unaryOp.apply("Kasun"));

        BinaryOperator<String>  binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("Kasun", "Buddhi"));

        ArrayList<String> al = new ArrayList<>();
        al.add("a");al.add("b");
        Consumer<String> stringConsumer = System.out::println;
        for(int i=0; i< al.size(); i++) {
            stringConsumer.accept(al.get(i));
        }

        // Bound Method Reference
        List<String> namesList = Arrays.asList("Peter", "Mary", "John");
        namesList.forEach(s -> System.out.println(s));
        namesList.forEach(System.out::println);

        // Unbound Method Reference
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        printC.accept(upperL.apply("kasun"));
        printC.accept(upperMR.apply("kasun"));

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        printC.accept(concatL.apply("kasun ", "Buddhi"));
        printC.accept(concatMR.apply("kasun ", "Buddhi"));

        // Static Method Reference
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR =  Collections::sort;

        List<Integer> numberList = Arrays.asList(2,3,9,4,8,7);
        sortL.accept(numberList);
        System.out.println(numberList);

        numberList = Arrays.asList(2,3,9,4,8,7);
        sortMR.accept(numberList);
        System.out.println(numberList);

        Supplier<StringBuilder> sbl = () -> new StringBuilder();
        Supplier<StringBuilder> sblMR = StringBuilder::new;

        StringBuilder sb1 = sbl.get(); sb1.append("lambda version"); printC.accept(sb1.toString());
        StringBuilder sb2 = sblMR.get(); sb2.append("Method Reference version"); printC.accept(sb2.toString());


    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);

    }
}



interface Evaluate<T> {
    boolean isNavigate(T t);
}
