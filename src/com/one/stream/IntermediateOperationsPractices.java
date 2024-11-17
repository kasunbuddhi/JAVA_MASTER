package com.one.stream;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        System.out.println();

        //flatMap
        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("mary", "ann");

        Stream<List<String>> streamOfList = Stream.of(list1, list2);
        streamOfList.flatMap(list -> list.stream())
                .forEach(System.out::print);

        System.out.println();

        //Sorted
        Person john = new Person("John", 23);
        Person mary = new Person("mary", 25);

        Stream.of(mary, john)
                .sorted(Comparator.comparing(p -> p.getAge()))
                .forEach(System.out::print);

        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.println(" 0." + name))
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.println(" 1." + name))
                .sorted()
                .peek(name -> System.out.println(" 2." + name))
                .limit(2)
                .forEach(name -> System.out.println(" 3. " + name));


    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
