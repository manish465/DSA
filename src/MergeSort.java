import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1,0,-1};
        sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;

            sort(arr,start,mid);
            sort(arr,mid + 1,end);
            merge(arr,start,mid,end);
        }
    }

    private static void merge(int[] arr,int start,int mid,int end){
        int lefArrLength = mid - start + 1;
        int rightArrLength = end - mid;

        int[] leftArr = new int[lefArrLength];
        int[] rightArr = new int[rightArrLength];

        for(int i=0;i<lefArrLength;i++)
            leftArr[i] = arr[start + i];
        for (int i=0;i<rightArrLength;i++)
            rightArr[i] = arr[mid + 1 + i];

        int i=0,j=0,k=start;

        while (i < lefArrLength && j < rightArrLength){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i<lefArrLength){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j<rightArrLength){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
