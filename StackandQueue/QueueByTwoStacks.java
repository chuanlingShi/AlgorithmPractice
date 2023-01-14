package StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/** Java: Implement a queue by using two stacks.
 * The queue should provide size(), isEmpty(), offer(), poll() and peek() operations.
 * When the queue is empty, poll() and peek() should return null.
 *
 */
public class QueueByTwoStacks {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int size;

    public QueueByTwoStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        size = 0;
    }

    public Integer poll() {
        if (isEmpty()) return null;
        peek();
        size--;
        return stack1.pollFirst();
    }

    public void offer(int element) {
        stack2.offerFirst(element);
        size++;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        if (stack1.isEmpty()) {
            move();
        }
        return stack1.peekFirst();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void move() {
        while (!stack2.isEmpty()) {
            stack1.offerFirst(stack2.pollFirst());
        }
    }
}
