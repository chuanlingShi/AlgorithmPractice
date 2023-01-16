package StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithmin {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public StackWithmin() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        min.pollFirst();
        return stack.pollFirst();
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (min() == -1 || element < min()){
            min.offerFirst(element);
        } else {
            min.offerFirst(min());
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peekFirst();
    }

    public int min() {
        if (min.isEmpty()) return -1;
        return min.peekFirst();
    }
}
