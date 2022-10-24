package question.fastandslowpointer;

public class MiddleOfTheLinkedList {
    public static ListNode solution1(ListNode head){
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(solution1(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println(solution1(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(solution1(head).value);
    }
}
