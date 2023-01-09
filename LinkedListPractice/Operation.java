package LinkedListPractice;

public class Operation {
    public int length(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode get(ListNode head, int index) {
        //if (index < 0 || index >= length(head)) return null; // 不能这样写， 复杂度O(n)
        if (index < 0) return null;
        ListNode cur = head;
        int i = 0;
        while (cur != null && i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    public ListNode appendHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }

    public ListNode appendTail(ListNode head, int value) {
        ListNode tail = new ListNode(value);
        ListNode cur = head;
        if (cur == null) return tail;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
        return head;
    }


}
