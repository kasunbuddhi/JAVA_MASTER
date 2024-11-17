package com.one.stream;

import java.util.stream.Stream;

public class IntermediateOperationsPractices {
    public static void main(String[] args) {

        //Filter
        Stream.of("galway", "mayo", "roscommon")
                .filter(countryName -> countryName.length() > 5)
                .forEach(System.out::println);

        //distinct
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.println("1."+s))
                .distinct()
                .forEach(s -> System.out.println("2."+s));

        //limit
        Stream.of(11, 22, 33, 44, 10, 20, 55, 30, 66, 77, 88, 99 )
                .peek(n -> System.out.print(" A - " + n))
                .filter(n -> n > 40)
                .peek(n -> System.out.print(" B - " + n))
                .limit(2)
                .forEach(n -> System.out.println(" C - " + n));

        //map
        Stream.of("book", "pen", "ruler")
                .map(s -> s.length())
                .forEach(System.out::print);
    }
}
