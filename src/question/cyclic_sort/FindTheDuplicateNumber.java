package question.cyclic_sort;

// We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
// The array has only one duplicate but it can be repeated multiple times.
// Find that duplicate number without using any extra space.
// You are, however,
// allowed to modify the input array.

/*
0, 1, 2, 3, 4, 4
1, 2, 3, 3, 5, 4



 */

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 4, 3, 2})); // 4
        System.out.println(solution(new int[]{2, 1, 3, 3, 5, 4})); // 3
        System.out.println(solution(new int[]{2, 4, 1, 4, 4})); // 4
    }

    public static int solution(int[] nums){
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

        for (int j=0; j<nums.length; j++)
            if(j + 1 != nums[j])
                return nums[j];
        return -1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
