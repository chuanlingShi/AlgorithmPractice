package StackandQueue;

public class MyQueue1 {

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyQueue1() {
        head = null;
        tail = null;
        size = 0;
    }

    public Integer poll() {
        if (isEmpty()) return null;
        //千万别忘了只有一个元素的时候，tail也要处理
        if (size() == 1){
            ListNode oldHead = head;
            head = null;
            tail = null;
            size--;
            return oldHead.value;
        }
        ListNode target = head;
        head = head.next;
        target.next = null;
        size--;
        return target.value;
    }

    public Integer peek() {
        return isEmpty() ? null : head.value;
    }

    public boolean offer(int value) {
        tail.next = new ListNode(value);
        tail = tail.next;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


}
