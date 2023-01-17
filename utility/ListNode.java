package utility;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    public static ListNode toLinkedList(int[] array) {
        if(array == null || array.length < 1) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        if(array.length == 1) {
            return head;
        }
        ListNode cur = head;
        for(int i = 1; i < array.length; i ++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {

        while (head != null){
            System.out.print(head.value);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
