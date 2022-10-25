package question;

//Given a string, find the length of the longest substring which has no repeating characters

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static int solution(String s){
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxlen = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if (map.size() == (right - left + 1))
                maxlen = Math.max(maxlen, (right - left + 1));

            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                left++;
            }
            right++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabccbb"));
        System.out.println(solution("abbbb"));
        System.out.println(solution("abccde"));
    }
}
