package String;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        // create a new StringBuilder
        StringBuilder sb=new StringBuilder();

        // test for append method
        sb.append("a");
        System.out.println(sb);

        // test for insert method
        sb.insert(1,"bcdef");
        System.out.println(sb);

        // test for delete method
        sb.delete(1,3);
        System.out.println(sb);

        // test for deleteCharAt(int index) method
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

        // test for reverse method
        sb.reverse();
        System.out.println(sb);

        // test for replace(int start, int end, String str) method
        sb.replace(0,1,"ab");
        System.out.println(sb);

        // test for setLength() method
        sb.setLength(2);
        System.out.println(sb);

        List<Integer> list = new ArrayList<>();
        list.add(null);
        System.out.println("size" + list.size());
    }
}
