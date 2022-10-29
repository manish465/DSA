package question.two_pointers;

// Given an array of unsorted numbers and a target number,
// find all unique quadruplets in it,
// whose sum is equal to the target number.

/*
* 2, 0, -1, 1, -2, 2
* -2, -1, -1, 0, 1, 2, 2 - sort
* i    j
* arr[a] + arr[b] + arr[c] + arr[d] = target
* arr[a] + arr[b] = target - (arr[a] + arr[b])
*
*
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 1, 2, -1, 1, -3}, 1)); // [-3, -1, 1, 4], [-3, 1, 1, 2]
        System.out.println(solution(new int[] {2, 0, -1, 1, -2, 2}, 2)); // [[0, -1, 1, 2]]
    }

    public static List<List<Integer>> solution(int[] arr, int target){
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i < arr.length - 3; i++){
            if(i > 0 && arr[i-1] == arr[i])
                continue;
            for(int j = i+1; j < arr.length - 2; j++){
                if(arr[j-1] == arr[j])
                    continue;
                helper(arr, target - (arr[i] + arr[j]), output, i, j);
            }
        }

        return output;
    }

    private static void helper(int[] arr, int target, List<List<Integer>> output, int i, int j){
        int left = j + 1, right = arr.length - 1;

        while (left < right){
            int currSum = arr[left] + arr[right];

            if(currSum > target)
                right--;
            else if(currSum < target)
                left++;
            else {
                output.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left] - 1)
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            }
        }
    }
}

// Solution
// This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.
// We can follow a similar approach to iterate through the array,
// taking one number at a time.
// At every step during the iteration,
// we will search for the quadruplets similar to Triplet Sum to Zero whose sum is equal to the given target.