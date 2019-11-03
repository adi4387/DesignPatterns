package com.learn.problems;

import java.util.*;
import java.util.stream.Collectors;

/** Divide an array of integer into
 * 2 such that sum of integers in
 * 1st array is smaller than 2nd array.
 * Find all possible arrays
 */

public class DivideArraySumGreater {

    public static void main(String[] args) {
        DivideArraySumGreater.divide_Array_Into_2_Such_That_Sum_Of_1st_Arr_Is_Smaller_Than_2nd_Arr();
    }

    public static void divide_Array_Into_2_Such_That_Sum_Of_1st_Arr_Is_Smaller_Than_2nd_Arr(){
        int[] array = {1,2,3,4,5,6};
        int length = array.length;
        int i = 0, j = 0;
        while(i < length) {
            subsetArray(pushElementAtTheEnd(array, i, length), length);
            i++;
        };
    }

    private static int[] pushElementAtTheEnd(int[] array, int i, int length) {
        int[] temp = new int[length];
        int j = 0;
        System.arraycopy(array, i, temp, 0, length - i);
        while(i > 0) {
            temp[length - i] = array[j++];
            i--;
        }
        System.out.println(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        return temp;
    }

    private static void subsetArray(int[] array, int length) {
        int[] temp;
        int[] temp2;
        for(int i = 0; i<length; i++) {
            temp = new int[i+1];
            System.arraycopy(array, 0, temp, 0, i+1);
            System.out.println();
            temp2 = new int[length-(i+1)];
            System.arraycopy(array, i+1, temp2, 0, length-(i+1));
            System.out.println();
            printArray(Arrays.stream(temp).boxed().collect(Collectors.toList()), Arrays.stream(temp2).boxed().collect(Collectors.toList()));
        }
    }

    public static void printArray(List<Integer> first, List<Integer> second) {
        if(first.stream().mapToInt(Integer::intValue).sum() < second.stream().mapToInt(Integer::intValue).sum()) {
            System.out.println("First : " + first + " - Second : " + second);
        }
    }
}
