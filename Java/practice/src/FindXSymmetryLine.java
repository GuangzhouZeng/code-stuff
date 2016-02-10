import java.util.*;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class FindXSymmetryLine {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int findLine(Point[] points){
        int n = points.length;
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.x - p2.x;
            }
        });

        int median = (n & 1) == 1 ? points[n / 2].x : (points[n / 2 - 1].x + points[n / 2].x) / 2;

        for(Point point: points){
            // traverse all the point to make sure all the node in the arrays has a accordingly node
            //other wise return -1;
            //So I think here we use a arraylist to store all points is better.
            //we can check the node exists by using contains
        }
        return median;
    }

    public static void main(String[] args){
        Point[] points = new Point[1];
        points[0] = new Point(1,2);
        System.out.println(findLine(points));
    }
}
