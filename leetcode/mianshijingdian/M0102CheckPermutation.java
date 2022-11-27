package leetcode.mianshijingdian;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2022-11-15
 */
public class M0102CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] a1 = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - '0']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            a1[s2.charAt(i) - '0']--;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        M0102CheckPermutation m = new M0102CheckPermutation();
        System.out.println();
        System.out.println(m.CheckPermutation("abc", "cba"));
    }
}
