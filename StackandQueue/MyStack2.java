package StackandQueue;

public class MyStack2 {
    //head 指向stack的顶部
    private int head;

    private int[] array;

    public MyStack2(int capacity) {
        array = new int[capacity];
        head = -1;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    public Integer pop() {
        if (head == -1) {
            return null;
        }
        return array[head--];
    }

    public boolean push(int value) {
        if (isFull()) {
            return false;
        }
        array[++head] = value;
        return true;

    }

    public boolean isFull() {
        return size() == array.length;
    }

    public int size() {
        return head + 1;
    }

    public boolean isEmpty() {
        return head == -1;
    }



}
