package recursionSorting;

public class FibonacciNumberLite {
    public int fibonacci(int K) {
        // corner case
        if (K < 0) {
            return 0;
        }
        //base case
        if (K == 0) {
            return 0;
        }
        if (K == 1) {
            return 1;
        }
        //sub problem
        //recursive rule: f(n) = f(n-1) + f(n-2)
        return fibonacci(K - 1) + fibonacci(K - 2);
    }
    //TC: O(2^K), SC: O(K)
}
