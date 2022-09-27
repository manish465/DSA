import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 3, 2, 1,0,-1})));
    }

   public static int[] sort(int arr[]){
       for(int i=0;i < arr.length - 1;i++){
           for(int j=i+1;j < arr.length;j++){
               if(arr[i] > arr[j]){
                   swap(arr, i, j);
               }
           }
       }

       return arr;
   }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
