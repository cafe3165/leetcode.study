package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-16
 */
public class T3FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {

        int[] a = new int[100005];
        for (int num : nums) {
            if (a[num] > 0) {
                return num;
            }
            a[num] = a[num] + 1;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        T3FindRepeatNumber t = new T3FindRepeatNumber();
        int[] a = {3, 4, 2, 0, 0, 1};

        System.out.println(t.findRepeatNumber(a));
    }

}
