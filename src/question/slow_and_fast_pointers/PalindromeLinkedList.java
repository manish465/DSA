package question.slow_and_fast_pointers;

// Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
// Your algorithm should use constant space and the input LinkedList
// should be in the original form once the algorithm is finished.
// The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        System.out.println(solution(head)); // true

        head.next.next.next.next.next = new ListNode(2);
        System.out.println(solution(head)); // false
    }

    public static boolean solution(ListNode head){
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfRev = rev(slow);
        ListNode secondHalfRevCopy = secondHalfRev;

        while (head != null && secondHalfRev != null){
            if(head.value != secondHalfRev.value)
                break;
            head = head.next;
            secondHalfRev = secondHalfRev.next;
        }

        rev(secondHalfRevCopy);

        if(head == null || secondHalfRev == null) return true;
        return false;

    }

    private static ListNode rev(ListNode head){
        ListNode prev = null;

        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
