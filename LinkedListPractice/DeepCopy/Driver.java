package LinkedListPractice.DeepCopy;
import test.RandomListNode;

public class Driver {
    public static void main(String[] argv) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next.next;
        head.next.random = head.next.next.next.next;

        DeepCopy instance = new DeepCopy();
        RandomListNode node = instance.deepCopy(head);
    }

}
