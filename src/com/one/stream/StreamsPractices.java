package com.one.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
//import java.util.stream.Stream;

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

        //Stream Laziness
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {System.out.println("filter: "+ s);
                    return true;})
                .forEach(s -> {System.out.println("filter2: "+ s);});

        Stream.of("Alex", "David", "April", "Edward")
                .map(s -> {System.out.println("filter3: "+ s);
                    return s.toUpperCase();})
                .anyMatch(s -> {System.out.println("filter4: "+ s);
                    return s.startsWith("A");});

        List<String> names = Arrays.asList("April", "ben", "Charlie", "David", "Benildus", "Christian");
        names.stream()
                .peek(System.out::println)
                .filter(s -> {System.out.println("filter5: "+ s);
                return s.startsWith("B") || s.startsWith("C");})
                .filter(s -> {System.out.println("filter6: "+ s);
                    return s.length() > 3;})
                .limit(1)
                .forEach(System.out::println);

        //Creating Streams
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number Of Elements " + streamAnimals.count());

        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22); namesToAges.put("Mary", 24); namesToAges.put("Alice", 31);
        System.out.println("Number of entries: "+
                namesToAges
                        .entrySet()
                        .stream()
                        .count());


    }




}
