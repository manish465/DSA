package question.twopointers;

/*
* 1, 0, 2, 1, 0
* i           j
*
* */


import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2, 1, 0};
        solution(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] arr){
        int start = 0, end = arr.length - 1, i = 0;

        while (i < end){
            if(arr[i] == 0){
                swap(arr,i,start);
                i++;
                start++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr,i,end);
                end--;
            }
        }

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
