package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInASubstring {
    public static void main(String[] args) {
        String s1 = "aaacb", s2 = "abc";

        System.out.println(solution(s1,s2));
    }

    public static boolean solution(String s1, String s2){
        int start = 0, end = 0;
        Map<Character,Integer> charFreq1 = new HashMap<>();
        Map<Character,Integer> charFreq2 = new HashMap<>();

        for(char c:s2.toCharArray())
            charFreq2.put(c,charFreq2.getOrDefault(c,0) + 1);

        while (end < s1.length()){
            char endChar = s1.charAt(end);
            charFreq1.put(endChar,charFreq1.getOrDefault(endChar,0)+1);

            while (charFreq1.size() > charFreq2.size()){
                char startChar = s1.charAt(start);
                charFreq1.put(startChar,charFreq1.get(startChar) - 1);
                if(charFreq1.get(startChar) == 0)
                    charFreq1.remove(startChar);
                start++;
            }

            if(charFreq1.equals(charFreq2))
                return true;

            end++;
        }

        return false;
    }
}
