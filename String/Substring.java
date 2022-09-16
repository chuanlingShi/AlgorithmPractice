package String;

public class Substring {
    public int Substring(String large, String small) {
        // Write your solution here
        if(large.length() < small.length()){
            return -1;
        }
        if(small.length() == 0){
            return 0;
        }
        for (int i = 0; i <= large.length()- small.length(); i++){
            if(equals(large,i, small)){
                return i;
            }
        }
        return -1;
    }

    public boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
