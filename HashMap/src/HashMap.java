import java.util.Arrays;

public class HashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOADFACTOR = 0.75;
    private static final double SCALE_FACTOR = 1.5;


    private Node[] array;//array of entries

    private int size;//the numbers of key value pairs
    private double loadFactor;

    public HashMap() {
        this.array = new Node[DEFAULT_CAPACITY];
        this.loadFactor = DEFAULT_LOADFACTOR;
    }

    public HashMap(int cap, double loadFactor){
        if(cap <= 1){
            throw new IllegalArgumentException("cap can not be <= 1");
        }
        this.array = new Node[cap];
        this.loadFactor = loadFactor;

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    //non-negative
    private int hash(String key){
        if(key == null){
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(String key){
        return hash(key) % array.length;
    }

//     override equals when generic type
//    private boolean equalsValue(V v1, V v2){
//        if(v1 == null && v2 == null){
//            return true;
//        }
//        if(v1 == null || v2 == null){
//            return false;
//        }
//        return v1.equals(v2);
//
//    }

    //O(n), traverse the whole array, and each of the linked list in the array
    public boolean containsValue(Integer value){
        if(isEmpty()){
            return false;
        }
        for(Node node : array){
            while (node != null){
                if(node.getValue().equals(value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public boolean containsKey(String key){
        int index = getIndex(key);
        Node node = array[index];
        while(node != null){
            if(node.getKey().equals(key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //if key is not in the HashMap, return null
    public Integer get(String key){
        int index = getIndex(key);
        Node node = array[index];
        while(node != null){
            if(node.getKey().equals(key)){
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public Integer put(String key, Integer v){
        int index = getIndex(key);
        Node head = array[index];
        Node cur = head;
        while(cur != null){
            if(cur.getKey().equals(key)){
                Integer old = cur.getValue();
                cur.setValue(v);
                return old;
            }
            cur = cur.next;
        }
        Node newHead = new Node(key, v);
        newHead.next = head;
        array[index] = newHead;
        size ++;
        if(needRehashing()){
            rehashing();
        }
        return null;
    }

    private boolean needRehashing(){
        double ratio = ((double) size) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing(){
        //for each node in the old array add to the head of linked list to the new array
        Node[] oldArray = this.array;
        this.array = new Node[(int)(array.length * SCALE_FACTOR)];

        for(Node node : oldArray){
            while(node != null){
                Node next = node.next;// 防止丢失
                int index = getIndex(node.getKey());//new index
                node.next = array[index]; // 把新的node接到 new array头上
                array[index] = node;// update new head
                node = next;
            }
        }
    }

    public Integer remove(String key){
        //get index
        //delete on the linked list
        //size --
        int index = getIndex(key);
        Node node = array[index];
        Node prev = null;
        while(node != null){
            if(node.getKey().equals(key)){
                if(prev != null){
                    prev.next = node.next;
                } else {
                    array[index] = node.next;
                }
                size --;
                return node.getValue();
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
}
