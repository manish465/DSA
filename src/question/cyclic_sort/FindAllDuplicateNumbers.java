package question.cyclic_sort;

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
// The array has some duplicates,
// find all the duplicate numbers without using any extra space.

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 4, 5, 5})); // [4, 5]
        System.out.println(solution(new int[]{5, 4, 7, 2, 3, 5, 3})); // [3, 5]
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
        for(i=0; i<nums.length; i++)
            if(i + 1 != nums[i])
                output.add(nums[i]);

        return output;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
