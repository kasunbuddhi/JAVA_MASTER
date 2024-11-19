package com.one.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamsPractices {
    public static void main(String[] args) {

        int[] ia = {1, 2, 3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la = {1L, 2L, 3L};

        IntStream iStream1 = Arrays.stream(ia);
        DoubleStream dStream1 = Arrays.stream(da);
        LongStream lStream1 = Arrays.stream(la);

        IntStream iStream2 = IntStream.of(1, 2, 3);
        DoubleStream dStream2 = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream lStream2 = LongStream.of(1L, 2L, 3L);

        Stream<Integer> numbers = Stream.of(1, 2, 3);
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2));

        IntStream intS = Stream.of(1, 2, 3).mapToInt(n -> n);
        int total = intS.sum();
        System.out.println(total);

        // Common Primitive Stream Methods
        OptionalInt max = IntStream.of(10, 20, 30).max();
        Consumer<OptionalInt> optionalIntConsumer = PrimitiveStreamsPractices::accept;
        optionalIntConsumer.accept(max);

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0).min();
        System.out.println(min.orElseThrow());

        OptionalDouble average = LongStream.of(10L, 20L, 30L).average();
        System.out.println(average.orElseGet(Math::random));
    }

    private static void accept(OptionalInt max1) {
        if (max1.isPresent()) {
            System.out.println(max1.getAsInt());
        }
    }
}
