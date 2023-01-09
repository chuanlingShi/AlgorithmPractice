package LinkedList;

public class MergeTwoLists {
    //tc: O(m + n)
    //sc: O(1)
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode dummyHead = new ListNode(-1);
        ListNode curOne = one;
        ListNode curTwo = two;
        ListNode cur =  dummyHead;
        while (curOne != null && curTwo != null) {
            if (curOne.value < curTwo.value) {
                cur.next = curOne;
                curOne = curOne.next;
            } else {
                cur.next = curTwo;
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }
        if (curOne != null) {
            cur.next = curOne;
        }else {
            cur.next = curTwo;
        }
        return dummyHead.next;
    }
}
