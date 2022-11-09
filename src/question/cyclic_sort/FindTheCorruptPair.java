package question.cyclic_sort;

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
// The array originally contained all the numbers from 1 to ‘n’,
// but due to a data error,
// one of the numbers got duplicated which also resulted in one number going missing.
// Find both these numbers.

/*
0, 1, 2, 3, 4
3, 1, 2, 5, 2

*/

import java.util.Arrays;

public class FindTheCorruptPair {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sloution(new int[]{3, 1, 2, 5, 2}))); // [2, 4]
        System.out.println(Arrays.toString(sloution(new int[]{3, 1, 2, 3, 6, 4}))); // [3, 5]
    }

    public static int[] sloution(int[] arr){
        int i = 0;
        while (i < arr.length){
            int j = arr[i] - 1;
            if(arr[i] != arr[j])
                swap(arr, i, j);
            else
                i++;
        }

        for (i=0; i<arr.length; i++)
            if(i+1 != arr[i])
                return new int[]{i+1,arr[i]};
        return new int[]{-1,-1};
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
