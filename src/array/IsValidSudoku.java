package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] line = new HashMap[9];
        Map<Integer, Integer>[] son = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            line[i] = new HashMap<>();
            son[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int a = c - '0';
                    int k = (i / 3) * 3 + j / 3;
                    row[i].put(a, row[i].getOrDefault(a, 0) + 1);
                    line[j].put(a, line[j].getOrDefault(a, 0) + 1);
                    son[k].put(a, son[k].getOrDefault(a, 0) + 1);
                    if ((row[i].get(a) > 1) || (line[j].get(a) > 1) || (son[k].get(a) > 1)) {
                        return false;
                    }
                }


            }

        }
        return true;
    }
}
