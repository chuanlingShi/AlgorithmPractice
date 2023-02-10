package DPI;

public class Fibonacci {
    public long fibonacci(int K) {
        if (K <= 0) return 0;
        if (K == 1) return 1;
        long pre1 = 0;
        long pre2 = 1;
        long result = 0;
        for (int i = 2; i <= K; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
