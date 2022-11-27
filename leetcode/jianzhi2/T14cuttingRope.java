package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-25
 */
public class T14cuttingRope {

    public int cuttingRope(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmpMax = 0;
            for (int j = 1; j < i; j++) {
                tmpMax = Math.max(tmpMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = tmpMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        T14cuttingRope t = new T14cuttingRope();
        System.out.println(t.cuttingRope(10));

    }
}
