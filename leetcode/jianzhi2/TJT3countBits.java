package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-20
 */
public class TJT3countBits {


    public int[] countBits(int n) {

        int[] res = new int[n + 1];
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        TJT3countBits t = new TJT3countBits();
        System.out.println(t.countBits(5));
    }
}
