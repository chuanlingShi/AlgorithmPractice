package LinkedList;

public class MergeSortLinkedList {
    //tc: O(nlogn)
    //sc: O(logn)
    public ListNode mergeSort(ListNode head) {
        //find middle
        //recursion 1
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode sortedLeft = mergeSort(head);
        ListNode sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
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

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.value < right.value) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }else {
            cur.next = right;
        }
        return dummyHead.next;
    }
}
