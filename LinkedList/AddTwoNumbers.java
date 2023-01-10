package LinkedList;

public class AddTwoNumbers {
    //TC: O(n)
    //SC: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //add each digit with carry
        //new a node if carry is 1 at last digit
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.value + l2.value + carry) % 10);
            if ((l1.value + l2.value + carry) / 10 != 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.value + carry) % 10);
            if ((l1.value + carry) / 10 != 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.value + carry) % 10);
            if ((l2.value + carry) / 10 != 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
