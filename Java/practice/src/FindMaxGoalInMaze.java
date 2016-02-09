/**
 * Created by guangzhouzeng on 2/8/16.
 */
import java.util.*;
public class FindMaxGoalInMaze {
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int findInMaze(int[][] maze, Set<Integer> goals){
        if(maze == null || maze.length == 0 || maze[0].length ==0) return -1;
        int maxGoal = 0, m = maze.length, n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        int[][] dirs = {{1, 0}, {-1, 0},{0, 1},{0, -1}};
        while(!queue.isEmpty()){
            Point curPoint = queue.poll();

            if(goals.contains(maze[curPoint.x][curPoint.y])){
                maxGoal = Math.max(maxGoal, maze[curPoint.x][curPoint.y]);
            }

            for(int[] dir: dirs){
                int x = dir[0] + curPoint.x, y = dir[1] + curPoint.y;

                if(x >= 0 && x < m && y >=0 && y < n && visited[x][y] == false
                        && maze[curPoint.x][curPoint.y] >= maze[x][y]){
                    queue.add(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }

        return maxGoal;
    }

    public static void main(String[] args){
        int[][] maze = {{9,8,6,7,8},
                        {8,6,7,6,5},
                        {4,5,6,7,5},
                        {4,3,2,4,5},
                        {3,2,2,4,2}};

        Set<Integer> goals = new HashSet<>();
        goals.add(2);
        goals.add(5);
        goals.add(7);

        System.out.println(findInMaze(maze, goals));

    }
}
