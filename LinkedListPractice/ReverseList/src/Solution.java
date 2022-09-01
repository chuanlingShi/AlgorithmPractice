package LinkedListPractice.ReverseList.src;

public class Solution {
    public static void main(String[] argv){
        //        Node node1 = null;
        Node node1 = new Node(1);


        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        Node head = reverseList(node1);
        printList(head);

    }

    static Node reverseList(Node head){
        //corner case
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    static void printList(Node head){
        if (head == null){
            System.out.println(head);
        }else {
            Node cur = head;
            while(cur != null){
                System.out.println(cur.value);
                cur = cur.next;
            }
        }
    }
}
