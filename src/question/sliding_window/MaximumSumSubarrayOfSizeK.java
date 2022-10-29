package question.sliding_window;

/*
* Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
* */

public class MaximumSumSubarrayOfSizeK {
    public static int solution(int[] arr, int k){
        int left = 0, right = 0, maxSum = 0, windowSum = 0;

        while (right < arr.length){
            windowSum += arr[right];

            if((right - left + 1) == k){
                maxSum = Math.max(maxSum,windowSum);
                windowSum -= arr[left];
                left++;
            }
            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 5, 1, 3, 2}, 3));
        System.out.println(solution(new int[] {2, 3, 4, 1, 5}, 2));
    }
}
