package QueueStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack.
 * If the stack is empty, min() should return -1.
 *
 * push(int element) - push the element to top
 * pop() - return the top element and remove it, if the stack is empty, return -1
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 */
public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }
    public void push(int x) {
        stack.offerFirst(x);
        if (minStack.isEmpty() || x <= minStack.peekFirst()) {
            minStack.offerFirst(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer result = stack.pollFirst();
        if (minStack.peekFirst().equals(result)) {
            minStack.pollFirst();
        }
        return result;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }
}
