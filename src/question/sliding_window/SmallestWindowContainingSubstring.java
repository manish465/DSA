package question.sliding_window;

//Given a string and a pattern,
// find the smallest substring in the given string which has all the characters of the given pattern.

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {
    public static String solution(String str, String pattern){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        int left = 0, right = 0, matched = 0;
        int startIdx = 0, size = str.length() + 1;

        while (right < str.length()){
            char rightChar = str.charAt(right);

            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) >= 0)
                    matched++;
            }

            while (matched == pattern.length()){
                if((right - left + 1) < size){
                    size = (right - left + 1);
                    startIdx = left;
                }

                char leftChar = str.charAt(left);

                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0)
                        matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }

                left++;
            }
            right++;
        }

        return size > str.length() ? "\"\"" : str.substring(startIdx, startIdx + size);
    }

    public static void main(String[] args){
        System.out.println(solution("aabdec","abc"));
        System.out.println(solution("abdabca","abc"));
        System.out.println(solution("adcad","abc"));
    }
}
