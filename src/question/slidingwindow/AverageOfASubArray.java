package question.slidingwindow;

import java.util.ArrayList;

public class AverageOfASubArray {
    public static ArrayList<Double> bruteForce(int arr[], int k){
        ArrayList<Double> result = new ArrayList<Double>();

        for(int i=0;i <= arr.length - k;i++){
            double sum = 0;
            for(int j=i;j < i + k;j++)
                sum += arr[j];
            result.add(sum/k);
        }

        return result;
    }

    public static ArrayList<Double> slidingWindow(int arr[], int k){
        ArrayList<Double> result = new ArrayList<Double>();
        double windowSum = 0;
        int start = 0,end = 0;

        while (end < arr.length){
            windowSum = windowSum + arr[end];

            if(end >= k - 1){
                result.add(windowSum/k);
                windowSum = windowSum - arr[start];
                start++;
            }
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new  int[] {1,3,2,6,-1,4,1,8,2};

        System.out.println(bruteForce(arr,5));
        System.out.println(slidingWindow(arr,5));
    }
}
