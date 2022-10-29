package question.two_pointers;
//Given an array of unsorted numbers,
//find all unique triplets in it that add up to zero.

/*
* -3, 0, 1, 2, -1, 1, -2
*
* -3, -2, -1, 0, 1, 1,  2
*  c   l   r
* a + b + c = 0
* a + b = -c
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> solution(int[] arr){
        Arrays.sort(arr);

        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i < arr.length - 2; i++){
            if(i > 0 && arr[i-1] == arr[i])
                continue;
            twoSum(arr,-arr[i],i+1,output);
        }

        return output;
    }

    private static void twoSum(int[] arr, int target, int left, List<List<Integer>> output){
        int right = arr.length - 1;

        while (left < right){
            int currentSum = arr[left] + arr[right];

            if(currentSum > target)
                right--;
            else if(currentSum < target)
                left++;
            else {
                output.add(Arrays.asList(-target,arr[left],arr[right]));
                right--;
                left++;

                while (left < right && arr[left - 1] == arr[left])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(solution(new int[]{-5, 2, -1, -2, 3}));
    }
}

//Solution #
//This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
//A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets
// with a target sum of zero.
//To follow a similar approach,
//first, we will sort the array and then iterate through it taking one number at a time.
//Let’s say during our iteration we are at number ‘X’,
//so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0X+Y+Z==0.
//At this stage, our problem translates into finding a
//pair whose sum is equal to “-X−X” (as from the above equation Y + Z == -XY+Z==−X).
//Another difference from Pair with Target Sum is that we need to find all the unique triplets.
//To handle this,
//we have to skip any duplicate number.
//Since we will be sorting the array,
//so all the duplicate numbers will be next to each other and are easier to skip.