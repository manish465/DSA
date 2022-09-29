package algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1,0,-1};
        sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start < end){
            int partitionIdx = partition(arr,start,end);

            sort(arr,start,partitionIdx - 1);
            sort(arr,partitionIdx + 1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int partitionIdx = start;

        for (int i= start;i<end;i++){
            if(arr[i] <= pivot){
                swap(arr,i,partitionIdx);
                partitionIdx = partitionIdx + 1;
            }
        }

        swap(arr,partitionIdx,end);

        return partitionIdx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
