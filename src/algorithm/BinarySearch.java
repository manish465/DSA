package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,4,5,6},5));
    }

    public static int search(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] > target)
                end = mid - 1;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
