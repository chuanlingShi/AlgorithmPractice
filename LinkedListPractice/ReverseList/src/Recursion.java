package LinkedListPractice.ReverseList.src;

import java.util.List;

public class Recursion {
    public ListNode reverse(ListNode head){
        //base case
        if(head == null || head.next == null ){
            return head;
        }

        ListNode subproblem = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return subproblem;
    }
}
