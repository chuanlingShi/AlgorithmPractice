package LinkedList;

public class ReOrderLinkedList {
    //tc:
    //sc:
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = reverse(mid.next);
        mid.next = null;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (left != mid.next) {
            cur.next = left;
            cur.next.next = right;
            left = left.next;
            right = right.next;
            cur = cur.next;
        }
        return dummyHead.next;
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

    }

}
