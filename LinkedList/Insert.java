package LinkedList;

public class Insert {
    //tc: O(n)
    //sc: O(1)
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        ListNode target = new ListNode(value);
        if (head == null || head.value >= value) {
            target.next = head;
            return target;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.value < target.value) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = target;
        target.next = next;
        return head;
    }
}
