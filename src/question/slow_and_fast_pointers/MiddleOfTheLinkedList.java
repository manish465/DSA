package question.slow_and_fast_pointers;

// Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
// If the total number of nodes in the LinkedList is even, return the second middle node.


public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(solution(head).value); // 3

        head.next.next.next.next.next = new ListNode(6);
        System.out.println(solution(head).value); // 4

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(solution(head).value); // 4
    }

    public static ListNode solution(ListNode head){
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

// Solution #
// One brute force strategy could be to first count the number of
// nodes in the LinkedList and then find the middle node in the second iteration.
// Can we do this in one iteration?
// We can use the Fast & Slow pointers method such that the fast pointer is
// always twice the nodes ahead of the slow pointer.
// This way, when the fast pointer reaches the end of the LinkedList,
// the slow pointer will be pointing at the middle node.