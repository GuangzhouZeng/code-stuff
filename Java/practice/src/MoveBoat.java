/**
 * Created by guangzhouzeng on 2/13/16.
 */
import java.util.*;
public class MoveBoat {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static List<List<Point>> findPath(int[][] grid, int h){
        if(grid == null || grid.length == 0 || grid[0].length == 0
                || grid[grid.length - 1][grid[0].length - 1] > h
                || grid[0][0] > h){
            return new ArrayList<>();
        }

        List<Point> cur = new ArrayList<>();
        List<List<Point>> res = new ArrayList<>();

        dfsHelper(grid, h, 0, 0, grid.length - 1, grid[0].length - 1, cur, res);
        return res;
    }

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static void dfsHelper(int[][] grid, int h, int i, int j, int m, int n, List<Point> cur, List<List<Point>> res){
        cur.add(new Point(i, j));
        grid[i][j] = -grid[i][j];

        if(i == m && j == n){
            res.add(new ArrayList<>(cur));
        }

        for(int[] dir: dirs){
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x > m || y < 0 || y > n || grid[x][y] > h || grid[x][y] < 0) continue;
            dfsHelper(grid, h, x, y, m, n, cur, res);
        }
        cur.remove(cur.size() - 1);
        grid[i][j] = -grid[i][j];
    }

    private static void printPoint(List<List<Point>> paths){
        System.out.println("Total Path: " + paths.size());
        for(List<Point> points: paths){
            for(Point point: points){
                System.out.print(" ("+point.x + ", " + point.y + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[][] grid = {
                {2,2,2,2,2},
                {7,4,5,8,2},
                {2,4,6,4,2},
                {3,5,6,5,2},
                {0,3,4,4,3}
        };
        printPoint(findPath(grid, 4));

    }

}
