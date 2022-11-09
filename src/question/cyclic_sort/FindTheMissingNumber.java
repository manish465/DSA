package question.cyclic_sort;

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

/*
0, 1, 2, 3
0, 1, 4, 3

0, 1, 3, 4

 */

public class FindTheMissingNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 0, 3, 1})); // 2
        System.out.println(solution(new int[]{8, 3, 5, 2, 4, 6, 0, 1})); // 7
    }

    public static int solution(int[] arr){
        int i = 0;
        while (i < arr.length){
            if(arr[i] < arr.length && arr[i] != i)
                swap(arr, i, arr[i]);
            else
                i++;
        }

        for (int j=0; j < arr.length; j++)
            if(arr[j] != j)
                return j;
        return arr.length;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
