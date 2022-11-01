package question.slow_and_fast_pointers;

// Any number will be called a happy number if,
// after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
// leads us to number ‘1’.
// All other (not-happy) numbers will never reach ‘1’.
// Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

/*

23 :
2* 2 + 3*3 = 13
1*1 + 3*3 = 10
1*1 + 0*0 = 1

 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(solution(23)); // true
        System.out.println(solution(12)); // false
    }

    public static boolean solution(int num){
        int slow = num, fast = num;

        do {
            slow = helper(slow);
            fast = helper(helper(fast));
        }while (slow != fast);

        return slow == 1;
    }

    private static int helper(int num){
        int sum = 0, digit;

        while (num != 0){
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}

// Solution #
// The process, defined above, to find out if a number is a happy number or not,
// always ends in a cycle. If the number is a happy number,
// the process will be stuck in a cycle on number ‘1,’
// and if the number is not a happy number then the process will be stuck in a cycle with a set of numbers.
// As we saw in Example-2 while determining if ‘12’ is a happy number or not,
// our process will get stuck in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
// We saw in the LinkedList Cycle problem that we can use
// the Fast & Slow pointers method to find a cycle among a set of elements.
// As we have described above, each number will definitely have a cycle.
// Therefore, we will use the same fast & slow pointer strategy to find the cycle and once the cycle is found,
// we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.