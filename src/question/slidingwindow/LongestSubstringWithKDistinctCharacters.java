package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "cbbebi";
        int k = 3;

        System.out.println(solution(s,k));
    }

    public static int solution(String s,int k){
        int start = 0, end = 0;
        Map<Character,Integer> dict = new HashMap<>();
        int maxLen = 0;

        while (end < s.length()){
            char rc = s.charAt(end);
            dict.put(rc,dict.getOrDefault(rc,0) + 1);

            while (dict.size() > k){
                char lc = s.charAt(start);
                dict.put(lc, dict.get(lc) - 1);
                if(dict.get(lc) == 0)
                    dict.remove(lc);
                start++;
            }

            maxLen = Math.max(maxLen,end - start + 1);
            end++;
        }

        return maxLen;
    }
}
