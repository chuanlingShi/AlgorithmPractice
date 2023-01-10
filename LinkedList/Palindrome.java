package LinkedList;

public class Palindrome {
    //tc: O(n)
    //sc: O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //find mid
        ListNode mid = findMid(head);
        //de-link
        ListNode right = mid.next;
        mid.next = null;
        //reverse right half
        ListNode reversedRight = reverse(right);
        //compare two lists
        return compare(head, reversedRight);
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
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private boolean compare(ListNode one, ListNode two) {
        while (two != null) {
            if (one.value != two.value) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return true;
    }
}
