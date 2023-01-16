import java.util.Arrays;

public class Challenge590 {
    public static int neighborMines(int[][] matrix, int r, int c) {
        if (matrix[r][c] == 1)
            return 9;
        
        int out = 0;
        for (int i = r - 1; i <= r + 1; i++)
            for (int j = c - 1; j <= c + 1; j++) {
                if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
                    continue;
                
                if ( !(i == r && j == c) && matrix[i][j] == 1 )
                    out++;
            }
        
        return out;
    }
    
    public static int[][] countMines(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                copy[i][j] = neighborMines(matrix, i, j);
        
        return copy;
    }
    
    public static void main(String args[]) {
        int[][] mines = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0}
        };
        
        System.out.println( Arrays.deepToString(countMines(mines)) );
        // [[1, 9, 2, 1], [2, 3, 9, 2], [3, 9, 4, 9], [9, 9, 3, 1]]
    }
}
