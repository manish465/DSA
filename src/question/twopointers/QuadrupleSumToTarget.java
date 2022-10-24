package question.twopointers;


import java.util.*;

/*
* 4, 1, 2, -1, 1, -3
* -3, -1, 1, 1, 2, 4
*  i   j
*
*
* */
public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 1, 2, -1, 1, -3};
        int target = 1;

        System.out.println(solution(arr,target));
    }

    public static List<List<Integer>> solution(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i < arr.length - 3; i++){
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            for(int j=i+1; j < arr.length - 2; j++){
                if(j > i+1 && arr[j] == arr[j-1])
                    continue;
                findPair(arr,i,j,target,output);
            }
        }

        return output;
    }

    private static void findPair(int[] arr,int i, int j, int target, List<List<Integer>> output){
        int left = j + 1, right = arr.length - 1;

        while (left < right){
            int sum = arr[left] + arr[right] + arr[i] + arr[j];

            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else {
                output.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left-1])
                    left++;
                while (left < right && arr[right] == arr[right+1])
                    right--;
            }
        }
    }
}
