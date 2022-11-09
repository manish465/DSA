package question.cyclic_sort;

// We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
// The array can have duplicates,
// which means some numbers will be missing.
// Find all those missing numbers.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
0, 1, 2, 3, 4, 5, 6, 7
1, 2, 3, 1, 2, 3, 5, 8


 */

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 8, 2, 3, 5, 1})); // 4, 6, 7]
        System.out.println(solution(new int[]{2, 4, 1, 2})); // [3]
        System.out.println(solution(new int[]{2, 3, 2, 1})); // [4]
    }

    public static List<Integer> solution(int[] nums){
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;

            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;

        }

        List<Integer> output = new ArrayList<>();
        for (int j=0; j < nums.length; j++)
            if(nums[j] != j)
                output.add(j+1);
        return output;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
