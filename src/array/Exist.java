package array;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。'
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (search(board, word, visited, 0, i, j)) {
                    return true;
                }
                ;
            }

        }
        return false;
    }

    public boolean search(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
        int stringLength = word.length();
        int iLength = board.length;
        int jLength = board[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[i][j] = true;
        boolean result = false;
        //System.out.println("查找数组[" + i + "]" + "[" + j + "],是否匹配字符串" + index + "位");

        if (board[i][j] == word.charAt(index)) {
            if (index == stringLength - 1) {
                return true;
            } else {
                for (int[] direction : directions) {
                    int newi = i + direction[0];
                    int newj = j + direction[1];
                    if (index < stringLength && 0 <= newi && newi < iLength && 0 <= newj && newj < jLength) {
                        if (!visited[newi][newj]) {
                            if (search(board, word, visited, index + 1, newi, newj)) {
                                result = true;
                                break;
                                //return true;
                            }

                        }
                    }
                }
            }
        }

        visited[i][j] = false;
        return result;
    }





    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
