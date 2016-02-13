/**
 * Created by guangzhouzeng on 2/12/16.
 */
//0: bacteria
//1: air
//2: pesticide

import java.util.*;
public class Bacteria {
    public static boolean isAlive(int[][] grid, int i, int j){
        if(grid == null || grid.length ==0 || grid[0].length == 0){
            return false; //invalid input
        }
        int m = grid.length, n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0) return false; //invalid input;

        return dfsHelper(grid, i, j, m, n);
    }
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};

    //need 1 to alive
    private static boolean dfsHelper(int[][] grid, int i, int j, int m, int n){
        if(grid[i][j] == 1) return true;
        grid[i][j] = 2;

        for(int[] dir: dirs){
            int x = dir[0] + i, y = dir[1] + j;
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2){
                if(dfsHelper(grid, x, y, m, n)) return true;
            }
        }
        return false;
    }

    public static boolean isAliveBFS(int[][] grid, int i, int j){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return false;
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >=n || grid[i][j] != 0) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        //grid[i][j] = 2;

        final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            grid[cur[0]][cur[1]] = 2;
            for(int[] dir: dirs){
                int x = dir[0] + cur[0], y = dir[1] + cur[1];
                if(x >= 0 && x < m && y >= 0 && y < n){
                    if(grid[x][y] == 0){
                        queue.add(new int[]{x, y});
                    }else if(grid[x][y] == 1){
                        return true;
                    }
                    //grid[x][y] = 2;
                }
            }
        }
        return false;
    }

    private static boolean dfsHelper2(int[][] grid, int i, int j, int m, int n){
        grid[i][j] = 2;

        for(int[] dir: dirs){
            int x = dir[0] + i, y = dir[1] + j;
            if(x < 0 || x >=m || y < 0 || y > n || grid[x][y] == 1) return true;
            if(dfsHelper2(grid, x, y, m, n)) return true;
        }
        return false;
    }

    //need at least one hold to get outside of pesticide


    public static void main(String[] args){
        int[][] grid = {
                {2,2,2,2,2},
                {2,0,0,1,2},
                {2,0,2,2,2},
                {2,0,0,0,2},
                {2,2,2,2,2}
        };

        System.out.println(isAlive(grid, 3, 3));
        int[][] grid2 = {
                {2,2,2,2,0},
                {2,0,0,0,0},
                {2,0,2,2,0},
                {2,0,0,0,1},
                {2,2,2,2,2}
        };

        System.out.println(isAliveBFS(grid2, 3, 3));
    }
}
