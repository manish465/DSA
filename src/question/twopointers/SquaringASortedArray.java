package question.twopointers;

import java.util.Arrays;

public class SquaringASortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-3, -1, 0, 1, 2};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr){
        int left = 0, right = arr.length - 1;
        int[] ans = new int[arr.length];
        int lastIdx = ans.length - 1;

        while(left <= right){
            int leftSqr = arr[left] * arr[left];
            int rightSqr = arr[right] * arr[right];

            if(leftSqr > rightSqr){
                ans[lastIdx--] = leftSqr;
                left++;
            }else{
                ans[lastIdx--] = rightSqr;
                right--;
            }
        }

        return ans;
    }
}
