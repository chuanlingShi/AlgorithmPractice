package StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        if (s1.size() == 1) return;
        Deque<Integer> s2 = new ArrayDeque<>();
        sort(s1, s2);
    }

    private void sort(Deque s1, Deque s2) {
        while (!s1.isEmpty()) {
            int globalMin = Integer.MAX_VALUE;
            int countMin = 0;
            //数
            while (!s1.isEmpty()) {
                int cur = (int) s1.pollFirst();
                if (cur < globalMin) {
                    globalMin = cur;
                    countMin = 1;
                } else if (cur == globalMin) {
                    countMin++;
                }
                s2.offerFirst(cur);
            }
            //分拣
            while (!s2.isEmpty() && (int) s2.peekFirst() >= globalMin) {
                int cur = (int) s2.pollFirst();
                if (cur > globalMin) {
                    s1.offerFirst(cur);
                }
            }
            for (int i = 0; i < countMin; i++) {
                s2.offerFirst(globalMin);
            }
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }

}
