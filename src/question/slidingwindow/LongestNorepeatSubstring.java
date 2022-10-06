package question.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNorepeatSubstring {
    public static void main(String[] args) {
        String s = "abccde";

        System.out.println(solution(s));
    }

    public static int solution(String s){
        int start = 0, end = 0;
        Map<Character,Integer> charSet = new HashMap<>();
        int maxLen = 0;

        while(end < s.length()){
            charSet.put(s.charAt(end),charSet.getOrDefault(s.charAt(end),0) + 1);

            while (charSet.size() != (end - start + 1)){
                charSet.put(s.charAt(start),charSet.get(s.charAt(start)));
                if(charSet.get(s.charAt(start)) == 0)
                    charSet.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen,(end - start + 1));

            end++;
        }

        return maxLen;
    }
}
