import PrintOut.PrintArray;

/**
 * Created by guangzhouzeng on 2/10/16.
 */
/*
matrix:
0: free space;
1: status;
2: flower;

dp:
0 ~ n: count of flower
-1: status, should stop
-2: flower, not stop, but never be counted as a place to observe flower.
*/
    /*
    * improvement:
    * 1. use less space: flip the flower and status to be negative. Then use the same idea to store the count into
    * the matrix where in a free space.
    *
    * */

public class ObserveFlower {
    public static int getMostFlower(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];


        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 2){
                    dp[i][j] = -2;
                    fillColRow(matrix, i, j, dp);
                }else if(matrix[i][j] == 1){
                    dp[i][j] = -1;
                }
            }
        }
        System.out.println("--------------------------");
        PrintArray.print2DArray(dp);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    private static void fillColRow(int[][] matrix, int i, int j, int[][] dp){
        int tempi = i, tempj = j;
        while(--tempi >=0 && matrix[tempi][j] != 1){ //go up
            if(matrix[tempi][j] == 0) dp[tempi][j]++;
        }
        tempi = i;
        while(++tempi < matrix.length && matrix[tempi][j] != 1){ // go down
            if(matrix[tempi][j] == 0) dp[tempi][j]++;
        }
        while(--tempj >= 0 && matrix[i][tempj] != 1){ // go left
            if(matrix[i][tempj] == 0) dp[i][tempj]++;
        }
        tempj = j;
        while(++tempj < matrix[0].length && matrix[i][tempj] != 1){ //go right
            if(matrix[i][tempj] == 0) dp[i][tempj]++;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {0,0,2,0,1},
                {0,2,0,1,0},
                {0,1,0,0,2},
                {0,2,0,0,2},
                {0,0,0,2,0}};

        PrintArray.print2DArray(matrix);
        System.out.println(getMostFlower(matrix));

    }
}