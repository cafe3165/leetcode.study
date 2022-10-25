package leetcode.mianshijingdian;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2022-10-16
 */
public class M0101isUnique {

    public static boolean isUnique(String astr) {
        if (astr == null ) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        char[] charArray = astr.toCharArray();
        for(char c : charArray) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
     String   s = "leetcode";
        System.out.println(isUnique(s));

    }
}
