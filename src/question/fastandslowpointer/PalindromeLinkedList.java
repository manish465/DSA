package question.fastandslowpointer;

public class PalindromeLinkedList {
    public static boolean solution1(ListNode head){
        ListNode rev;

        ListNode start = head;

        while (start != null){
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println(solution1(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println(solution1(head));
    }
}
