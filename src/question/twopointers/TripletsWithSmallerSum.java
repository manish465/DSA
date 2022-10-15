package question.twopointers;

/*
* -1, 4, 2, 1, 3  t= 5
*  0, 1, 2, 3, 4
* -1, 1, 2, 3, 4
*  i     l  r
* sum = 4
* c = 4
*
* */

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 4, 2, 1, 3};
        int target = 5;

        System.out.println(solution(arr,target));
    }

    public static int solution(int[] arr,int target){
        int count = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1, right = arr.length - 1;

            while(left < right){
                int currentSum = arr[i] + arr[left] + arr[right];

                if(currentSum < target){
                    count += right - left;
                    left++;
                }else
                    right--;
            }
        }
        return count;
    }
}
