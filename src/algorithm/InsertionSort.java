package algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 3, 2, 1,0,-1})));
    }

    public static int[] sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int hold = arr[i];
            int j = i - 1;

            while(j >=0 && arr[j] > hold) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = hold;
        }

        return arr;
    }
}
