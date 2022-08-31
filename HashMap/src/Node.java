public class Node{
    //key 是final不需要setter
    private final String key;
    private Integer value;
    Node next;

    public Node(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
