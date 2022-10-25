package leetcode.jianzhi2;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2022-10-16
 */
public class T4findNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }


        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == target || matrix[i][col - 1] == target) {
                return true;
            }
            if (matrix[i][0] < target && matrix[i][col - 1] > target) {
                int colIndex = findMid(matrix[i], target);

                int[] colArray = copyColArray(matrix, colIndex, i);
                int rowIndex = findMid(colArray, target);
                return matrix[rowIndex + i][colIndex] == target || matrix[rowIndex + i + 1][colIndex] == target;
            }
        }

        return false;
    }

    private static int[] copyColArray(int[][] matrix, int targetCol, int startCol) {
        int[] array = new int[matrix.length - startCol];
        int index = 0;
        for (int i = startCol; i < matrix.length; i++) {
            array[index++] = matrix[i][targetCol];

        }
        return array;
    }


    private static int findMid(int[] array, int num) {

        int j = array.length - 1;
        int i = 0;
        int mid = (i + j) / 2;
        while (i < j) {
            mid = (i + j) / 2;
            if (array[mid] > num) {
                j = mid;
            } else if (array[mid] < num) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }


// 0 , 4, 2
//    0, 2, 1
//    1,2,1
//

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
//        int a = 5;

//        int[][] matrix = new int[][]{
//                {1, 4},
//                {2, 5}};
//        int a = 2;


//        int[][] matrix = new int[][]{{1,3,5}};
//        int a =3;

        int[][] matrix = new int[][]{{-1,3}};
        int a =1;

        System.out.println(T4findNumberIn2DArray.findNumberIn2DArray(matrix, a));
    }
}
