package question.twopointers;

import java.util.*;

public class TripletSumToZero {
    public static void main(String[] args) {
        int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};

        System.out.println(solution(arr));
     }

     public static List<List<Integer>> solution(int[] arr){
         int start = 0, end = arr.length - 1;
         Arrays.sort(arr);
         List<List<Integer>> output = new ArrayList<>();

         for(int i=0;i < arr.length - 2;i++){
             if(i>0 && arr[i] == arr[i+1])
                 continue;
             twoSum(arr,-arr[i],i+1,output);
         }

         return output;
     }

     public static void twoSum(int[] arr,int target,int startIdX,List<List<Integer>> output){
        int endIdx = arr.length - 1;

        while (startIdX < endIdx){
            int current = arr[startIdX] + arr[endIdx];

            if(current < target)
                startIdX++;
            else if(current > target)
                endIdx--;
            else{
                output.add(Arrays.asList(-target,arr[startIdX],arr[endIdx]));
                startIdX++;
                endIdx--;
                while (startIdX < endIdx && arr[startIdX] == arr[startIdX - 1])
                    startIdX++;
                while (startIdX < endIdx && arr[endIdx] == arr[endIdx + 1])
                    endIdx--;
            }
        }
     }
}
