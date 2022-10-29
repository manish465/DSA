package question.two_pointers;

//Given an array of unsorted numbers and a target number,
//find a triplet in the array whose sum is as close to the target number as possible,
//return the sum of the triplet.
//If there are more than one such triplet,
//return the sum of the triplet with the smallest sum.

import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {
    public static int solution(int[] arr, int target){
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++){
            int left = i + 1, right = arr.length - 1;

            while (left < right){
                int diff = target - (arr[i] + arr[left] + arr[right]);

                if(diff == 0)
                    return target - diff;

                if(Math.abs(diff) < Math.abs(smallestDiff))
                    smallestDiff = diff;

                if(diff > 0)
                    left++;
                else
                    right--;
            }
        }

        return target - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(solution(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(solution(new int[]{1, 0, 1, 1}, 100));
    }
}

//Solution
//This problem follows the Two Pointers pattern and is quite similar to Triplet Sum to Zero.
//We can follow a similar approach to iterate through the array,
//taking one number at a time.
//At every step,
//we will save the difference between the triplet and the target number,
//so that in the end, we can return the triplet with the closest sum.