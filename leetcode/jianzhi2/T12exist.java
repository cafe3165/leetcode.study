package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-10-26
 */
public class T12exist {

    public static boolean[][] visited = null;
    public static char[] words = null;


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int k) {
        if (r > board.length - 1 || r < 0 ||
                c > board[0].length - 1 || c < 0 ||
                visited[r][c] ||
                k > words.length - 1 || words[k] != board[r][c]) {
            return false;
        }
        
        visited[r][c] = true;
        if (k == words.length - 1) {
            return true;
        }

        boolean res = dfs(board, r + 1, c, k + 1) || dfs(board, r, c + 1, k + 1) ||
                dfs(board, r - 1, c, k + 1) || dfs(board, r, c - 1, k + 1);
        visited[r][c] = false;
        return res;
    }

    public static void main(String[] args) {
        T12exist t = new T12exist();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};


        System.out.println(t.exist(board, "ABCB"));
    }

}
