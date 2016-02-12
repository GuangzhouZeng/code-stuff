/**
 * Created by guangzhouzeng on 2/10/16.
 */
//find a point which left-up area is equal to its right-down area.
public class FindEqualPoint {
    static int[] findPoint(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{-1, -1};
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dp[i + 1][j + 1] == getRighLow(dp, i, j, m, n)){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static int getRighLow(int[][] dp, int i, int j, int m, int n){
        return dp[m][n] - dp[m][j] - dp[i][n] + dp[i][j];
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {5,4,3,2,1}
        };

        /*
        a1,a2,
        a3,a4

        s1,s2
        s3,s4

        Sum4 = s4 - s2 - s3 + s1;
        */

        int[] pos = findPoint(matrix);
        System.out.println(pos[0] + ", " + pos[1]);
    }
}
