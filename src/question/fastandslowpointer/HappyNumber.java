package question.fastandslowpointer;

/*
* 41 {}
*
*
* */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean solution1(int num){
        int slow = num, fast = num;

        do {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }while (fast != slow);

        return slow == 1;
    }

    private static int findSum(int num){
        int sum = 0;

        while (num != 0){
            sum += (num % 10) * (num % 10);
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution1(23));
        System.out.println(solution1(12));
    }
}
