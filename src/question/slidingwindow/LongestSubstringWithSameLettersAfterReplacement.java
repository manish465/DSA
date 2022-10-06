package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        String s = "abccde";
        int k=1;

        System.out.println(solution(s,k));
    }

    public static int solution(String s,int k){
        int start = 0, end = 0;
        Map<Character,Integer> charFreq = new HashMap<>();
        int maxLen = 0, maxCharFreqCount = 0;

        while (end < s.length()){
            char endChar = s.charAt(end);

            charFreq.put(endChar,charFreq.getOrDefault(endChar,0) + 1);
            maxCharFreqCount = Math.max(maxCharFreqCount,charFreq.get(endChar));

            while ((end - start + 1) - maxCharFreqCount > k){
                char startChar = s.charAt(start);
                charFreq.put(startChar,charFreq.get(startChar) - 1);
                if(charFreq.get(startChar) == 0)
                    charFreq.remove(startChar);
                start++;
            }

            maxLen = Math.max(maxLen,(end - start + 1));
            end++;
        }

        return maxLen;
    }
}
