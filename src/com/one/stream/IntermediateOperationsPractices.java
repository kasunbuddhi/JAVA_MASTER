package com.one.stream;

import java.util.stream.Stream;

public class IntermediateOperationsPractices {
    public static void main(String[] args) {

        //Filter
        Stream.of("galway", "mayo", "roscommon")
                .filter(countryName -> countryName.length() > 5)
                .forEach(System.out::println);
    }
}
