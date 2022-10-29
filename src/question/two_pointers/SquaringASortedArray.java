package question.two_pointers;

//Given a sorted array,
//create a new array containing squares of all the number of the input array in the sorted order.

/*
* -2,-1, 0, 2, 3
*    l      r
*
* 4 > 9
*
*
* */

import java.util.Arrays;

public class SquaringASortedArray {
    public static int[] solution(int[] arr){
        int[] output = new int[arr.length];

        int left = 0, right = arr.length - 1;

        for(int i = arr.length - 1; i >= 0; i--){
            int leftSqr = arr[left] * arr[left];
            int rightSqr = arr[right] * arr[right];

            if(leftSqr > rightSqr){
                output[i] = leftSqr;
                left++;
            }else {
                output[i] = rightSqr;
                right--;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{-2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{-3, -1, 0, 1, 2})));
    }
}

//Solution #
//This is a straightforward question.
//The only trick is that we can have negative numbers in the input array,
//which will make it a bit difficult to generate the output array with squares in sorted order.
//An easier approach could be to first find the index of the first non-negative number in the array.
//After that, we can use Two Pointers to iterate the array.
//One pointer will move forward to iterate the non-negative numbers and
//the other pointer will move backward to iterate the negative numbers.
//At any step,
//whichever number gives us a bigger square will be added to the output array.
