package question.sliding_window;


//Given a string and a pattern, find out if the string contains any permutation of the pattern.

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    public static boolean solution(String str, String pattern){
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, matched = 0;

        for(char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c,0) + 1);

        while (right < str.length()){
            char rightChar = str.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0)
                    matched++;
            }

            if(matched == map.size())
                return true;

            while (right - left + 1 >= pattern.length()){
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

        return false;
    }

    public static boolean solution1(String str, String pattern){
        Map<Character,Integer> strFreq = new HashMap<>();
        Map<Character,Integer> patternFreq = new HashMap<>();

        int left = 0, right = 0;

        for(char c : pattern.toCharArray())
            patternFreq.put(c, patternFreq.getOrDefault(c,0) + 1);

        while (right < str.length()){
            char rightChar = str.charAt(right);

            strFreq.put(rightChar, strFreq.getOrDefault(rightChar, 0) + 1);

            while ((right - left + 1) > pattern.length()){
                char leftChar = str.charAt(left);

                strFreq.put(leftChar, strFreq.get(leftChar) - 1);
                if(strFreq.get(leftChar) == 0)
                    strFreq.remove(leftChar);

                left++;
            }

            if(strFreq.equals(patternFreq))
                return true;

            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("oidbcaf","abc"));
        System.out.println(solution("odicf","dc"));
        System.out.println(solution("bcdxabcdy","bcdyabcdx"));
        System.out.println(solution("aaacb","abc"));
    }
}
