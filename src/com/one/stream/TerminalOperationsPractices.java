package com.one.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

        //reduce without identity
        BinaryOperator<Integer> op = (a,b) -> a+b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(6);
        Stream<Integer> mulElement = Stream.of(3, 4, 5);
        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        mulElement.reduce(op).ifPresent(System.out::println);

        Integer val = Stream.of(1, 1, 1)
                .reduce(1, (a, b) -> a);
        System.out.println(val);

        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce(0, (n, str) -> n + str.length(),
                (n1, n2) -> n1 + n2);
        System.out.println(length);

        //Collect
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word);

        // Collect, Same as above code with method reference
        StringBuilder word2 = Stream.of("ad", "jud", "i", "cate")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
        System.out.println(word2);

        //Collectors
        String str = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(str);

        Double avg = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.averagingDouble(s -> s.length()));
        System.out.println(avg);

        //Collectors to Map
        Map<String, Integer> map = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.toMap(
                        s -> s,
                        s -> s.length()
                ));
        System.out.println(map);

        Map<Integer, String> map2 = Stream.of("cake", "biscuits", "tart")
                .collect(Collectors.toMap(
                        s -> s.length(),
                        s -> s,
                        (s1, s2) -> s1+","+s2 )); // Merge function, append when duplicate key (length is same)
        System.out.println(map2);

        TreeMap<String, Integer> map3 = Stream.of("cake", "biscuits", "apple tart", "cake")
                .collect(Collectors.toMap(
                        s -> s,
                        s -> s.length(),
                        (len1, len2) -> len1 + len2,// if duplicate keys (same desert) add values
                        () -> new TreeMap<>()
                ));
        System.out.println(map3);
        System.out.println(map3.getClass());

        //Collectors to groupBy
        Stream<String> names2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map4 = names2.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map4);

        //Collectors groupingBy()
        Stream<String> names3 = Stream.of("Joe", "Tom", "Tom", "Alan", "peter");
        Map<Integer, Set<String>> map5 =  names3.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map5);

        Stream<String> names4 = Stream.of("Joe", "Tom", "Tom", "Alan", "peter");
        TreeMap<Integer, List<String>> map6 =
                names4.collect(
                    Collectors.groupingBy(
                            String::length,
                            TreeMap::new,
                            Collectors.toList()));
        System.out.println(map6);
        System.out.println(map6.getClass());

    }
}
