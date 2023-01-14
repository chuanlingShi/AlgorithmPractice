package StackandQueue;

public class MyStack1 {
    private ListNode top;
    private int size;

    public MyStack1(int top) {
        this.top = new ListNode(top);
        size = 1;
    }

    public MyStack1() {
        top = null;
        size = 0;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        ListNode oldTop = top;
        ListNode newTop = top.next;
        oldTop.next = null;
        top = newTop;
        size--;
        return oldTop.value;

    }

    //why boolean? 与array保持一致
    public boolean push(int top) {
        ListNode newTop = new ListNode(top);
        newTop.next = this.top;
        this.top = newTop;
        size++;
        return true;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return top.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}
