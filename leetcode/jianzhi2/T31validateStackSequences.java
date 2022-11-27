package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-11-21
 */
public class T31validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length == 0 && pushed.length == 0) {
            return true;
        }

        int[] stack = new int[pushed.length];
        int top = -1;
        int i = 0, j = 0;
        while (i < pushed.length) {
            stack[top + 1] = pushed[i];
            top++;
            i++;
            while (top >= 0 && stack[top] == popped[j] && j < popped.length) {
                top--;
                j++;
            }
        }
        if (j == i && top == -1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        T31validateStackSequences t = new T31validateStackSequences();
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
//        int[] pushed = {0,1}, popped = {0,1};

        System.out.println(t.validateStackSequences(pushed, popped));
    }


}
