package com.one.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperationsPractices {
    public static void main(String[] args) {

        //anyMatch, allMatch, noneMatch
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred));
        System.out.println(names.stream().allMatch(pred));
        System.out.println(names.stream().noneMatch(pred));

        //forEach
        Stream<String> names1 = Stream.of("Cathy", "Pauline", "Zoe");
        names1.forEach(System.out::println);

        //reduce
        String name = Stream.of("s", "e", "a", "n")
                .reduce("", (s, c) -> s+c);
        System.out.println(name);

        Integer product = Stream.of(2,3,4)
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);

    }
}
