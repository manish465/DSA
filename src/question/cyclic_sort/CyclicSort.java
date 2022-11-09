package question.cyclic_sort;

// We are given an array containing ‘n’ objects. Each object, when created, was assigned a
// unique number from 1 to ‘n’ based on their creation sequence.
// This means that the object with sequence number ‘3’
// was created just before the object with sequence number ‘4’.
//
// Write a function to sort the objects in-place on
// their creation sequence number in O(n)O(n) and without any extra space. For simplicity,
// let’s assume we are passed an integer array containing only the sequence numbers,
// though each number is actually an object.

/*
1, 2, 3, 4, 5  i = 0 , j = 0
0, 1, 2, 3, 4


 */

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 4, 2};
        solution(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5]

        input = new int[]{2, 6, 4, 3, 1, 5};
        solution(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5, 6]

        input = new int[]{1, 5, 6, 4, 3, 2};
        solution(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5, 6]
    }

    public static void solution(int[] arr){
        int i = 0;
        while (i < arr.length){
            int j = arr[i] - 1;
            if(arr[i] != arr[j])
                swap(arr,i,j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// we iterate the array one number at a time,
// and if the current number we are iterating is not at the correct index,
// we swap it with the number at its correct index.
// This way we will go through all numbers and place them in their correct indices,
// hence, sorting the whole array.
