package CrossTrainingIII;

import utility.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge K sorted lists into one big sorted list in ascending order.
 *
 * Assumptions
 *
 * ListOfLists is not null, and none of the lists is null.
 */
//nlogk; k
public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            if (cur.next.next != null) {
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
