package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-20
 */
public class T10Fib {

    //    F ( n ) = F ( n - 1 ) + F ( n - 2 )
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];

    }


    public static void main(String[] args) {
        T10Fib t = new T10Fib();
        System.out.println(t.fib(5));
    }
}
