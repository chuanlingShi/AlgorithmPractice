package LinkedList;

public class ReOrderLinkedList {
    //tc:O(n)
    //sc: O(1)
    public ListNode reorder(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        //de-link
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        ListNode reversedRight = reverse(right);
        return merge(left, reversedRight);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null)  {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            cur.next = left;
            left = left.next;
            cur.next.next = right;
            right = right.next;
            cur = cur.next.next;
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return dummyHead.next;
    }

}
