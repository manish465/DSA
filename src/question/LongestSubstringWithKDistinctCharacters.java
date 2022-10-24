package question;

/*
* Given a string, find the length of the longest substring in it with no more than K distinct characters.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public static int solution(String s, int k){
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if(map.size() == k)
                maxLen = Math.max(maxLen, (right - left + 1));

            while (map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(solution("araaci",2)); // 4
        System.out.println(solution("araaci",1)); // 2
        System.out.println(solution("cbbebi",3)); // 5
    }
}
