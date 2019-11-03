package com.learn.java.eight;

import com.learn.thread.LearningThread;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {
    int[] array = {1,2,3,4,5,6};
    int count = 0;

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b");
        List<List<String>> list2 = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        System.out.println(list1.stream().map(n -> n.toUpperCase()).collect(Collectors.toList()));
        System.out.println(list2.stream().flatMap(Collection::stream).collect(Collectors.toList()));
    }
}
