package StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        stack1.offerFirst(element);
    }

    public void offerLast(int element) {
        stack2.offerFirst(element);
    }

    public Integer pollFirst() {
        if (isEmpty()) return null;
        if (stack1.isEmpty()) {
            move(stack2, stack1);
        }
        return stack1.pollFirst();
    }
    public Integer peekFirst() {
        if (isEmpty()) return null;
        if (stack1.isEmpty()){
            move(stack2, stack1);
        }
        return stack1.peekFirst();
    }

    public Integer pollLast() {
        if (isEmpty()) return null;
        if (stack2.isEmpty()) {
            move(stack1, stack2);
        }
        return stack2.pollFirst();
    }


    public Integer peekLast() {
        if (isEmpty()) return null;
        if (stack2.isEmpty()) {
            move(stack1, stack2);
        }
        return stack2.peekFirst();
     }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void move(Deque<Integer> stackToPoll, Deque<Integer> stackToPush) {
        int size = stackToPoll.size();
        for (int i = 0; i < size;i++ ) {
            Integer element = stackToPoll.pollFirst();
            if (i < size/2) {
                buffer.offerFirst(element);
            } else {
                stackToPush.offerFirst(element);
            }
        }
        while (!buffer.isEmpty()) {
            stackToPoll.offerFirst(buffer.pollFirst());
        }
    }
}
