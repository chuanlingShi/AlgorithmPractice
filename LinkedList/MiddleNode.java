package LinkedList;

public class MiddleNode {
    //tc: O(n)
    //sc: O(1)
    public ListNode middleNode(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
