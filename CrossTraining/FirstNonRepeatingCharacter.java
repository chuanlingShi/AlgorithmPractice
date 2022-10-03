package CrossTraining;

import java.util.HashMap;
import java.util.HashSet;

public class FirstNonRepeatingCharacter {
    static class Node{
        Node prev;
        Node next;
        Character ch;

        Node(Character ch) {
            this.ch = ch;
        }
    }

    private Node head;
    private Node tail;

    private HashMap<Character, Node> singled;
    private HashSet<Character> repeated;

    public FirstNonRepeatingCharacter() {
        tail = new Node(null);
        tail.next = tail.prev = tail;
        head = tail;
        singled = new HashMap<>();
        repeated = new HashSet<>();
    }

    public void read(char ch) {
        if (repeated.contains(ch)) {
            return;
        }
        Node node = singled.get(ch);
        if (node == null) {
            node = new Node(ch);
            append(node);
        } else {
            remove(node);
        }
    }

    private void append(Node node) {
        singled.put(node.ch, node);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = tail.next;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == tail) {
            tail = node.prev;
        }
        node.prev = node.next = null;
        repeated.add(node.ch);
        singled.remove(node.ch);
    }

    public Character firstNonRepeating() {
        if (head == null) {
            return null;
        }
        return head.next.ch;
    }
}
