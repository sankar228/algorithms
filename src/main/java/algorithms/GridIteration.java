package algorithms;

import java.util.Arrays;

public class GridIteration {
    public static void main(String[] args) {
        GridIteration obj = new GridIteration();
        System.out.println(obj.griditerator(3,3));
        System.out.println(obj.griditerator(18,18));
    }

    public long griditerator(int m, int n){

        long[][] grid = new long[m+1][n+1];

        for(long[] a : grid) {
            Arrays.fill(a, 0);
        }

        grid[1][1] = 1;

        for(int i=0; i<= m; i++) {
            for(int j=0; j<= n; j++) {
                long e = grid[i][j];
                if(j +1 <= n)
                    grid[i][j+1] += e;
                if(i+1 <= m)
                    grid[i+1][j] += e;
            }
        }

        return grid[m][n];
    }
}
