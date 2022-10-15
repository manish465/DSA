package question.twopointers;


import java.util.*;

/*
* 4, 1, 2, -1, 1, -3
*    i
*{
* 5 = [[4,1]]
* 6 = [[4,2]]
* 3 = [[4,-1],[1,2]]
* 1 = [[4,-3],[2,-1]]
* 0 = [[1,-1]]
* 2 = [[1,1]]
* -2 = [[1,-3]]
* -1 = [[2,-3]]
* -4 = [[-1,-3]]
* }
*
*
* */
public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 1, 2, -1, 1, -3};
        int target = 1;

        System.out.println();
    }

    public static List<Integer[]> solution(int[] arr, int target){

        Map<Integer,List<Integer[]>> map = new HashMap<>();
        List<Integer[]> output = new ArrayList<>();

        for(int i = 1; i < arr.length - 1; i++){
            for(int j = i+1; j < arr.length; j++){
                int diff = target - (arr[i] + arr[j]);

                if(map.containsKey(diff)){
                    for(Integer[] pair : map.get(diff)){
                        Integer[] quad = {pair[0], pair[1], arr[i], arr[j]};
                        output.add(quad);
                    }
                }
            }

            for(int k = 0; k < i; k++){
                int sum = arr[i] + arr[k];
                Integer[] pair = {arr[k], arr[i]};

                if(map.containsKey(sum)){
                    map.get(sum).add(pair);
                }else {
                    List<Integer[]> list = new ArrayList<>();
                    list.add(pair);

                    map.put(sum,list);
                }
            }
        }

        return output;
    }
}
