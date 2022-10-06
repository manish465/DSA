package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        char[] c = new char[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;

        System.out.println(solution(c,k));
    }

    public static int solution(char[] c,int k){
        int start = 0, end = 0;
        Map<Character,Integer> charFreq = new HashMap<>();

        int maxLen = 0;

        while (end < c.length){
            char endChar = c[end];
            charFreq.put(endChar,charFreq.getOrDefault(endChar,0) + 1);

            while (charFreq.containsKey((char)0) && charFreq.get((char)0) > k){
                char startChar = c[start];
                charFreq.put(startChar,charFreq.get(startChar) - 1);
                if(charFreq.get(startChar) == 0)
                    charFreq.remove(startChar);
                start++;
            }

            maxLen = Math.max(maxLen,(end - start + 1));
            end++;
        }
        return  maxLen;
    }
}
