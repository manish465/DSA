package question.two_pointers;

//Given an array of sorted numbers,
//remove all duplicates from it.
//You should not use any extra space;
//after removing the duplicates in-place return the new length of the array.

/*
* 2, 3, 4, 11 removed = 2
*      ji
*
*/

public class RemoveDuplicates {
    public static int solution(int[] arr){
        int nextNonDuplicate = 1;

        for (int i = 1; i < arr.length; i++){
            if(arr[nextNonDuplicate - 1] != arr[i] ){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(solution(new int[]{2, 2, 2, 11}));
    }
}

//Solution #
//In this problem, we need to remove the duplicates
//in-place such that the resultant length of the array remains sorted.
//As the input array is sorted,
//therefore, one way to do this is to shift the elements left whenever we encounter duplicates.
//In other words,
//we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number.
//So our algorithm will be to iterate the array and whenever
//we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.