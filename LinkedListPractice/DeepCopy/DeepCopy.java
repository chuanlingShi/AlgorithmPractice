package LinkedListPractice.DeepCopy;
import test.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
 * Make a deep copy of the original list.
 */
public class DeepCopy {
    public RandomListNode deepCopy(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode copyHead = new RandomListNode(head.value);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, copyHead);
        RandomListNode cur = copyHead;

        while (head != null) {
            //connect next
            if (head.next != null) {
                if(!map.containsKey(head.next)){
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = map.get(head.next);
            }
            //connect random
            if (head.random != null){
                if(!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return copyHead;
    }

}
