package question.sliding_window;

/*
Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree.
You will pick one fruit from each tree until you cannot,
i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both the baskets.
*/

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static int solution(char[] fruits){
        Map<Character,Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < fruits.length){
            char rightChar = fruits[right];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if(map.size() == 2)
                maxLen = Math.max(maxLen, (right - left + 1));

            while (map.size() > 2){
                char leftChar = fruits[left];
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(solution(new char[]{'A', 'B', 'C', 'A', 'C'})); // 3
        System.out.println(solution(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})); // 5
    }
}
