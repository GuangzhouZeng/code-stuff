/**
 * Created by guangzhouzeng on 2/15/16.
 */
import java.util.*;
public class SmallestKElem {
    static class Point{
        int x;
        int y;
        int val;
        Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public static int kthSmallest(int[][] matrix, int k) {
        // write your code here

        PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.val - p2.val;
            }
        });

        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        pq.add(new Point(0, 0, matrix[0][0]));
        int res = matrix[0][0];
        visited[0][0] = true;
        while(k-- != 0){
            Point cur = pq.poll();
            res = cur.val;

            if(cur.x + 1 < m && !visited[cur.x + 1][cur.y]){
                pq.add(new Point(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if(cur.y + 1 < n && !visited[cur.x][cur.y + 1]){
                pq.add(new Point(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
        int k = 19;
        System.out.println(kthSmallest(arr, k));

    }
}


/*
[
[1,2,3,4,5],
[2,3,4,5,6],
[3,4,5,6,7],
[4,5,6,7,8]
]
, 19


[
[1,5,7],
[3,7,8],
[4,8,9]
],
4

[0,]
[]
 */