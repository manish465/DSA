package question.twopointers;

import java.util.*;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int target = 6;

        System.out.println(Arrays.toString(soution(nums, target)));
        System.out.println(Arrays.toString(soution1(nums, target)));
    }

    public static int[] soution(int[] nums, int target){
        int start = 0, end = nums.length - 1;

        while(start < end){
            int currentSum = nums[start] + nums[end];

            if(currentSum < target)
                start++;
            else if(currentSum > target)
                end--;
            else
                return new int[]{start,end};
        }

        return new int[]{-1,-1};
    }

    public static int[] soution1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++){
            int currentSub = target - nums[i];
            if(map.containsKey(currentSub))
                return new int[]{map.get(currentSub),i};
            else
                map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
