import java.util.LinkedList;
import java.util.List;

public class Driver {
    public static void main(String[] argv){
        ListNode node1 = new ListNode(1);


        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        Recursion recursion = new Recursion();
        ListNode head = recursion.reverse(node1);
//        ListNode head = reverseList(node1);
        printList(head);
    }

    static void printList(ListNode head){
        if (head == null){
            System.out.println(head);
        }else {
            ListNode cur = head;
            while(cur != null){
                System.out.println(cur.value);
                cur = cur.next;
            }
        }
    }
}
