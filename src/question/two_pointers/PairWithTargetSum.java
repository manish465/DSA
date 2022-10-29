package question.two_pointers;

//Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
//Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

/*
* 1, 2, 3, 4, 6  t= 6
*    l     r
*
* cs = 2 + 4 = 6
*
* */

import java.util.Arrays;

public class PairWithTargetSum {
    public static int[] solution(int[] arr, int target){
        int left = 0, right = arr.length - 1;

        while (left < right){
            int currentSum = arr[left] + arr[right];

            if(currentSum > target)
                right--;
            else if(currentSum < target)
                left++;
            else
                return new int[] {left, right};
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(solution(new int[] {2, 5, 9, 11}, 11)));
    }
}

//Solution
//Since the given array is sorted, a brute-force solution could be to iterate through the array,
//taking one number at a time and searching for the second number through Binary Search.
//The time complexity of this algorithm will be O(N*logN)O(N∗logN). Can we do better than this?
//We can follow the Two Pointers approach.
//We will start with one pointer pointing to the beginning of the array and another pointing at the end.
//At every step, we will see if the numbers pointed by the two pointers add up to the target sum.
//If they do, we have found our pair; otherwise, we will do one of two things:
//If the sum of the two numbers pointed by the two pointers is greater than the target sum,
//this means that we need a pair with a smaller sum. So, to try more pairs,
//we can decrement the end-pointer.
//If the sum of the two numbers pointed by the two pointers is smaller than the target sum,
//this means that we need a pair with a larger sum. So, to try more pairs,
//we can increment the start-pointer.