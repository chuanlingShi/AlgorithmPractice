package LinkedList;

public class PartitionLinkedList {
    //tc: O(n)
    //sc: O(1)
    public ListNode partition(ListNode head, int target) {
        //dummySmall, dummyLarge
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        ListNode small = dummySmall;
        ListNode large = dummyLarge;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value < target) {
                small.next = cur;
                small = small.next;
            }else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        //merge small and large
        small.next = dummyLarge.next;
        //link the tail of large to null
        large.next = null;
        return dummySmall.next;
    }
}
