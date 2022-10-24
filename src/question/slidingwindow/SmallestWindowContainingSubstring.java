package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC" , pattern = "ABC";

        System.out.println(solution(str,pattern));
    }

    public static String solution(String str, String pattern){
        int start = 0, end = 0, matched = 0, minLen = str.length() + 1, subStrStart = 0;
        Map<Character,Integer> patternFreq = new HashMap<>();

        for(char c: pattern.toCharArray())
            patternFreq.put(c,patternFreq.getOrDefault(c,0)+1);

        while(end < str.length()){
            char endChar = str.charAt(end);

            if(patternFreq.containsKey(endChar)){
                patternFreq.put(endChar,patternFreq.get(endChar) - 1);
                if(patternFreq.get(endChar) == 0)
                    matched++;
            }

            while (matched == pattern.length()){
                if(minLen > (end - start + 1)){
                    minLen = (end - start + 1);
                    subStrStart = start;
                }

                char startChar = str.charAt(start);
                if(patternFreq.containsKey(startChar)){
                    if(patternFreq.get(startChar) == 0)
                        matched--;
                    patternFreq.put(startChar,patternFreq.get(startChar) + 1);
                }

                start++;
            }

            end++;
        }

        return minLen > str.length() ? "\"\"" : str.substring(subStrStart,subStrStart + minLen);
    }
}
