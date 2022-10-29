package question.sliding_window;

/*
* Given an array of positive numbers and a positive number ‘S’, find the length of the smallest
* contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
*/

public class SmallestSubarrayWithAGivenSum {
    public static int solution(int[] arr, int s){
        int left = 0, right = 0, windowSum = 0, minLength = Integer.MAX_VALUE;

        while (right < arr.length){
            windowSum += arr[right];

            while (windowSum >= s){
                minLength = Math.min(minLength,(right - left + 1));
                windowSum -= arr[left];
                left++;
            }

            right++;
        }

        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 5, 2, 3, 2},7));
        System.out.println(solution(new int[]{2, 1, 5, 2, 8},7));
    }
}
