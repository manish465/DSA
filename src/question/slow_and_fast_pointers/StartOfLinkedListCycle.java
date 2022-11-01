package question.slow_and_fast_pointers;

// Given the head of a Singly LinkedList that contains a cycle,
// write a function to find the starting node of the cycle.

/*

 1, 2, 3, 4, 5, 2
            fs
 */

public class StartOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(solution(head).value); // 3

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(solution(head).value); // 4

        head.next.next.next.next.next.next = head;
        System.out.println(solution(head).value); // 1
    }

    public static ListNode solution(ListNode head){
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
