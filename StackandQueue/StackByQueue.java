package StackandQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement a stack with One Queue. We can access the size of Queue.
 */

public class StackByQueue {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public StackByQueue() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (isEmpty()) return null;
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public Integer top() {
        Integer element = pop();
        if (element != null) {
            queue.offer(element);
        }
        return element;

    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
