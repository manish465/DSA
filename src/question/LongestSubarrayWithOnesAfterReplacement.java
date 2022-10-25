package question;

/*
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.
*/

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithOnesAfterReplacement {
    public static int solution(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < arr.length){
            int rightInt = arr[right];

            map.put(rightInt, map.getOrDefault(rightInt, 0) + 1);

            if(map.containsKey(1) && (right - left + 1) - map.get(1) > k){
                int leftChar = arr[left];

                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }

            maxLen = Math.max(maxLen, (right - left + 1));

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(solution(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
