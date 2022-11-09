package question.inplacereversalofalinkedlist;

// Given the head of a LinkedList and two positions ‘p’ and ‘q’,
// reverse the LinkedList from position ‘p’ to ‘q’.

import question.slow_and_fast_pointers.ListNode;

public class ReverseASublist {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);//h
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = solution(head, 2, 4);
        while (result != null){
            System.out.print(result.value + " -> ");
            result = result.next;
        }
        System.out.print("NULL");
    }

    public static ListNode solution(ListNode head, int p, int q){
        ListNode left = head, beforeLeft = null;

        for(int i = 1; left != null && i < p; i++){
            beforeLeft = left;
            left = left.next;
        }

        ListNode current = left, prev = beforeLeft, next = null;

        for (int i = 0; current != null && i < q-p+1; i++ ){
            next = current.next;
            current.next = null;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode right = prev, afterRight = current;

        if(beforeLeft != null)
            beforeLeft.next = right;
        else
            head = right;

        left.next = afterRight;

        return head;
    }
}
