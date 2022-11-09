package question.inplacereversalofalinkedlist;

// Given the head of a Singly LinkedList, reverse the LinkedList.
// Write a function to return the new head of the reversed LinkedList.

/*
2 - 4 - 6 - 8 - 10 temp = n
h
2
r
 */

import question.slow_and_fast_pointers.ListNode;

public class ReverseALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = solution(head);
        while (result != null){
            System.out.print(result.value + " -> ");
            result = result.next;
        }
        System.out.print("NULL");
    }

    public static ListNode solution(ListNode head){
        ListNode current = head;
        ListNode rev = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = null;
            current.next = rev;
            rev = current;
            current = next;
        }

        return rev;
    }
}
