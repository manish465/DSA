package question.cyclic_sort;

// Given an unsorted array containing numbers, find the smallest missing positive number in it.

/*
 0, 1, 2, 3, 4
-3, 1, 5, 4, 2

*/

public class FindTheSmallestMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 1, 5, 4, 2})); // 3
        System.out.println(solution(new int[]{3, -2, 0, 1, 2})); // 4
        System.out.println(solution(new int[]{3, 2, 5, 1})); // 4
    }

    public static int solution(int[] arr){
        int i = 0;
        while (i < arr.length){
            int j = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[j])
                swap(arr, i, j);
            else
                i++;
        }

        for (i=0; i < arr.length; i++)
            if(arr[i] != i + 1)
                return i + 1;

        return -1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
