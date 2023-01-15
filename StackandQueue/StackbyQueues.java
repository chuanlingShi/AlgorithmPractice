package StackandQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackbyQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public StackbyQueues() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    //返回最后一个不为空的值
    public Integer pop() {
        if (isEmpty()) return null;
        Integer prev = queue1.poll();
        Integer cur = queue1.poll();
        while (cur != null) {
            queue2.offer(prev);
            prev = cur;
            cur = queue1.poll();
        }
        swap();
        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        if (isEmpty()) return null;
        Integer prev = queue1.poll();
        Integer cur = queue1.poll();
        while (cur != null) {
            queue2.offer(prev);
            prev = cur;
            cur = queue1.poll();
        }
        queue2.offer(prev);
        swap();
        return prev;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    private void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
