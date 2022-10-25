package question;

/*
* Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
* find the length of the longest substring having the same letters after replacement.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static int solution(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxFreqCharInMap = 0, maxLen = 0;

        while (right < s.length()){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxFreqCharInMap = Math.max(maxFreqCharInMap, map.get(rightChar));

            while ((right - left + 1) - maxFreqCharInMap > k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar) - 1);
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
        System.out.println(solution("aabccbb",2));
        System.out.println(solution("abbcb",1));
        System.out.println(solution("abccde",1));
    }
}
