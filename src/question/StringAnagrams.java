package question;

//Given a string and a pattern, find all anagrams of the pattern in the given string.
//Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> solution(String str, String pattern){
        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, matched = 0;
        List<Integer> output = new ArrayList<>();

        while (right < str.length()){
            char rightChar = str.charAt(right);

            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0)
                    matched++;
            }

            if(matched == map.size())
                output.add(left);

            while (right - left + 1 > pattern.length() - 1){
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

        return output;
    }

    public static void main(String[] args) {
        System.out.println(solution("ppqp","pq"));
        System.out.println(solution("abbcabc","abc"));
    }
}
