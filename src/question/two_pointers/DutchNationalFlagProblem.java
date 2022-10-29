package question.two_pointers;

// Given an array containing 0s, 1s and 2s, sort the array in-place.
// You should treat numbers of the array as objects, hence,
// we can’t count 0s, 1s, and 2s to recreate the array.

/*
*  0, 2, 0, 1, 2, 2
*  l  i     r
*
*/

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 0, 2, 1, 0}))); // [0, 0, 1, 1, 2]
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 0, 1, 2, 0}))); // [0, 1, 0, 2, 2, 2]
    }

    public static int[] solution(int[] arr){
        int i = 0;
        int left = 0, right = arr.length - 1;

        while (i < right){
            if(arr[i] == 0){
                swap(arr, i, left);
                i++;
                left++;
            }else if(arr[i] == 1)
                i++;
            else if(arr[i] == 2){
                swap(arr, i, right);
                right--;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
