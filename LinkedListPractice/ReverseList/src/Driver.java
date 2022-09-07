package LinkedListPractice.ReverseList.src;


import test.ListNode;

import static test.ListNode.printLinkedList;
import static test.ListNode.toLinkedList;

public class Driver {
    public static void main(String[] argv){
        int[] array = {1,2,3};
        ListNode head = toLinkedList(array);
        printLinkedList(head);

        Recursion recursion = new Recursion();
//        ListNode head = reverseList(node1);
    }
}
