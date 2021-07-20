package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;//3
        int column = matrix[0].length;//1
        int newrows = 0;
        int newcolumn = 0;
        List<Integer> list = new ArrayList<>();
        while (rows > newrows && column > newcolumn) {

            for (int j = newrows; j < column; j++) {

                list.add(matrix[newrows][j]);
            }
            for (int j = newrows + 1; j < rows; j++) {

                list.add(matrix[j][column - 1]);
            }
            if (rows - 1 > newrows) {
                for (int j = column - 2; j >= newcolumn; j--) {

                    list.add(matrix[rows - 1][j]);
                }
            }
            if (column - 1 > newcolumn) {
                for (int j = rows - 2; j > newcolumn; j--) {

                    list.add(matrix[j][newcolumn]);
                }
            }

            rows--;//2
            column--;//3
            newrows++;//1
            newcolumn++;//1

        }
        return list;
    }
}
