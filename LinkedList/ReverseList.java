package LinkedList;

public class ReverseList {
    //iterative way
    //TC: O(n)
    //SC: O(1)
    public ListNode reverse(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
