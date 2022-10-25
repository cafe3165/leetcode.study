package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-16
 */
public class T4findNumberIn2DArray2 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {

            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int a = 16;

//        int[][] matrix = new int[][]{
//                {1, 4},
//                {2, 5}};
//        int a = 2;


//        int[][] matrix = new int[][]{{1,3,5}};
//        int a =3;

//        int[][] matrix = new int[][]{{-1, 3}};
//        int a = 1;

        System.out.println(T4findNumberIn2DArray2.findNumberIn2DArray(matrix, a));
    }
}
