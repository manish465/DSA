package question;

/*
* Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
*/

import java.util.Arrays;

public class AverageOfAllContiguousSubarraysOfSizeK {
    public static double[] solution(int[] arr, int k){
        int left = 0, right = 0, windowSum = 0;
        double[] output = new double[arr.length - k + 1];

        while (right < arr.length){
            windowSum += arr[right];

            if ((right - left + 1) == k){
                output[left] = (double) windowSum / k;
                windowSum -= arr[left];
                left++;
            }

            right++;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5)));
    }
}
