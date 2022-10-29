package question.two_pointers;

// Given an array arr of unsorted numbers and a target sum,
// count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
// Write a function to return the count of such triplets.

/*
* -1, 4, 2, 1, 3   target = 3
* -1, 1, 2, 3, 4 - sort them
*  i  l  r
*
* current = 2 < 3
*
*
* */

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {-1, 0, 2, 3}, 3)); // 2
        System.out.println(solution(new int[] {-1, 4, 2, 1, 3}, 5)); // 4
    }

    public static int solution(int[] arr, int target){
        Arrays.sort(arr);

        int count = 0;

        for(int i = 0; i < arr.length - 2; i++){
            if(i > 0 && arr[i - 1] == arr[i])
                continue;
           count += helper(arr,target - arr[i], i);
        }

        return count;
    }

    private static int helper(int[] arr, int target, int i){
        int count = 0;
        int left = i + 1, right = arr.length - 1;

        while (left < right){
            int current = arr[left] + arr[right];

            if(current < target){
                count += right - left;
                left++;
            }else
                right--;
        }

        return count;
    }
}



// Solution
// This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.
// The only difference is that,
// in this problem, we need to find the triplets whose sum is less than the given target.
// To meet the condition i != j != k we need to make sure that each number is not used more than once.
// Following a similar approach, first we can sort the array and then iterate through it,
// taking one number at a time. Let’s say during our iteration we are at number ‘X’,
// so we need to find ‘Y’ and ‘Z’ such that X + Y + Z < targetX+Y+Z<target. At this stage,
// our problem translates into finding a pair whose sum is less than
// target - X (as from the above equation Y + Z == target - XY+Z==target−X).
// We can use a similar approach as discussed in Triplet Sum to Zero.