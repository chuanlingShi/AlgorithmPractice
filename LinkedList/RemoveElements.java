package LinkedList;

public class RemoveElements {
    //tc: O(n)
    //sc: O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null) {
            if (head.value == val) {
                head = head.next;
                pre.next = head;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}
