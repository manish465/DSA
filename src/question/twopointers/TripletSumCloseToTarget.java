package question.twopointers;

import java.util.Arrays;

/*
* -2,2,1,2 t=2
*    ^   ^
*   diff = target - (arr[a] + arr[b] + arr[c])
*  => (arr[a] + arr[b] + arr[c]) = target - diff
*   if diff = 0 ? return (arr[a] + arr[b] + arr[c]) OR (target - diff)
*
*
* */

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 1, 1};
        int target = 3;

        System.out.println(soution(arr,target));
    }

    public static int soution(int[] arr,int target){
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 2; i++){
            int left = i+1,right = arr.length - 1;

            while (left < right){
                int diff = target - (arr[i] + arr[left] + arr[right]);

                if(diff == 0)
                    return (target - diff);

                if(Math.abs(smallestDiff) > Math.abs(diff))
                    smallestDiff = diff;

                if(diff > 0)
                    left++;
                if (diff < 0)
                    right--;
            }
        }
        return target - smallestDiff;
    }
}
