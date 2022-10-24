package question.fastandslowpointer;

import java.util.HashSet;
import java.util.Set;

public class StartOfLinkedListCycle {
    public static ListNode solution1(ListNode head){
        Set<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp))
                return temp;
            else
                set.add(temp);

            temp = temp.next;
        }

        return null;
    }

    public static ListNode solution2(ListNode head){
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(solution2(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(solution2(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println(solution2(head).value);
    }
}
