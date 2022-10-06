package question.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringAnagrams {
    public static void main(String[] args) {
        String str = "abbcabc" , pattern = "abc";

        System.out.println(solution(str,pattern));
    }

    public static List<Integer> solution(String str,String pattern){
        int start = 0, end = 0;
        Map<Character,Integer> strFreq = new HashMap<>();
        Map<Character,Integer> patternFreq = new HashMap<>();

        List<Integer> output = new ArrayList<>();

        for(char c:pattern.toCharArray())
            patternFreq.put(c,patternFreq.getOrDefault(c,0) + 1);

        while(end < str.length()){
            char endChar = str.charAt(end);
            strFreq.put(endChar,strFreq.getOrDefault(endChar,0)+1);

            while((end - start + 1) > patternFreq.size()){
                char startChar = str.charAt(start);
                strFreq.put(startChar,strFreq.get(startChar) - 1);
                if(strFreq.get(startChar) == 0)
                    strFreq.remove(startChar);
                start++;
            }

            if(patternFreq.equals(strFreq))
                output.add(start);

            end++;
        }

        return output;
    }
}
