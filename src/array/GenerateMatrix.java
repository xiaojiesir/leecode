package array;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int row = 0;
        int column = 0;
        int count = 1;
        while (n > 0) {
            for (int i = column; i < n; i++) {
                result[row][i] = count++;

            }

            for (int i = row + 1; i < n; i++) {
                result[i][n - 1] = count++;

            }

            if (n - 1 > row) {
                for (int i = n - 2; i >= column; i--) {
                    result[n - 1][i] = count++;

                }
            }
            if (n - 1 > column) {
                for (int i = n - 2; i >= row + 1; i--) {
                    result[i][row] = count++;

                }
            }

            row++;
            column++;
            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix g = new GenerateMatrix();
        g.generateMatrix(4);
    }
}
