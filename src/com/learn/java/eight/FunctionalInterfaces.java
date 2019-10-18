package com.learn.java.eight;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<String> stringLengthChecker = (s) -> s.length() < 10;
        System.out.println(stringLengthChecker.test("Apple"));
        System.out.println(stringLengthChecker.negate().test("Apple"));

        Consumer<String> consumer2 = c -> System.out.println(c);
        consumer2.accept("Testing Consumer");
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        modify.andThen(dispList).accept(list);
        ;

        Function<Integer, String> function = (num) -> Integer.toString(num);
        System.out.println("LENGTH - "+function.apply(26).length());

        Supplier<String> sup = () -> "Hello";
        System.out.println(sup.get());

        BinaryOperator<Integer> add = (a,b) -> a+b;
        System.out.println(add.apply(100,20));

        UnaryOperator<String> upper = (str) -> str.toUpperCase();
        System.out.println(upper.apply("hello"));
        Runnable r = () -> System.out.println("Running Thread");
        Thread t = new Thread(r);
        t.start();

        BiFunction<String, String, String> bf = (str1, str2) -> str1 + " " + str2;
        System.out.println(bf.apply("Hello", "Anant"));

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.greet("Anant");

        IntFunction<String> intToStr = Integer::toString;
        System.out.println(intToStr.apply(10).length());

        Function<String, BigInteger> test = BigInteger::new;
        System.out.println(test.apply("-123456789").abs());

        List<String> names = Arrays.asList("James","John","Micky");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(names, (a, b) -> b.compareTo(a));
        List<Integer> intArray = Arrays.asList(1,2,3,4,5);
        List<String> namesStartingWithJ = names.stream().filter(s->s.startsWith("J")).collect(Collectors.toList());
        Consumer<List<String>> consumeList = System.out::println;
        consumeList.accept(namesStartingWithJ);
        Consumer<Object> consumerAnything = System.out::println;
        consumerAnything.accept(intArray.stream().mapToInt(n->n).sum());
    }


}
@FunctionalInterface
interface GreetingService {
    String message = "Hello";
    void greet(String message);
    default void print(String message) {
        System.out.println(message);
    }
}
