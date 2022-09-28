package algorithm;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 3, 2, 1,0,-1})));
    }

    public static int[] sort(int[] arr){
        for(int i=0;i < arr.length - 1;i++){
            int minIdx = i;

            for(int j=i+1;j<arr.length;j++)
                if(arr[minIdx] > arr[j])
                    minIdx = j;

            swap(arr, i, minIdx);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int minIdx) {
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}
