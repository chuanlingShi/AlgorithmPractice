package LinkedList;

public class ReverseRecursion {
    public ListNode reverse(ListNode head) {
        //TC: O(n)
        //SC: O(n)
        // base case
        if (head == null || head.next == null) return head;
        //sub problem
        ListNode subResult = reverse(head.next);
        //recursive rule
        head.next.next = head;
        head.next = null;
        return subResult;
    }
}
