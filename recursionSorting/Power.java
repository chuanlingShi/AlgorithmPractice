package recursionSorting;

public class Power {
    public long power(int a, int b) {
        // Write your solution here
        //base case
        if (b == 0) return 1;
        if (a == 0 ) return 0;
        //sub problem
        //recursive rule
        long half = power(a, b /2);
        if (b % 2 == 0) {
            return half * half;
        }else {
            return a * half * half;
        }
    }
}
