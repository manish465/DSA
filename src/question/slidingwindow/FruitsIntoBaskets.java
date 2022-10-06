package question.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        char[] fruits = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};

        System.out.println(solution(fruits));
    }

    public static int solution(char[] fruits){
        int start = 0, end = 0;
        Map<Character,Integer> fruitsFreq = new HashMap<>();

        int maxLen = 0;

        while (end < fruits.length){
            fruitsFreq.put(fruits[end],fruitsFreq.getOrDefault(fruits[end],0) + 1);

            while (fruitsFreq.size() > 2){
                fruitsFreq.put(fruits[start],fruitsFreq.get(fruits[start]) - 1);
                if(fruitsFreq.get(fruits[start]) == 0)
                    fruitsFreq.remove(fruits[start]);
                start++;
            }
            maxLen = Math.max(maxLen,end - start + 1);
            end++;
        }

        return maxLen;
    }
}
