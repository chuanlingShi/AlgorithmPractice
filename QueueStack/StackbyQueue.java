package QueueStack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement a stack containing integers using queue(s).
 * The stack should provide push(x), pop(), top() and isEmpty() operations.
 *
 * In java: if the stack is empty, then top() and pop() will return null.
 */
public class StackbyQueue {
    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public StackbyQueue() {
        q = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (q.isEmpty()) {
            return null;
        }
        int size = q.size();
        while(--size != 0) {
            q.offer(q.poll());
        }
        return q.poll();
    }

    /** Get the top element. */
    public Integer top() {
        if (q.isEmpty()) {
            return null;
        }
        int top = pop();
        q.offer(top);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q.isEmpty();
    }
}
