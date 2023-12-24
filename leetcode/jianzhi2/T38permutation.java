package leetcode.jianzhi2;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2022-12-03
 */
public class T38permutation {

    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {

        String[] array = set.toArray(new String[0]);

        return null;

    }


    private void dfs(String s, int idx) {
        if (idx == s.length()) {
            set.add(sb.toString());
        }


    }

    public static void main(String[] args) {

    }


}
