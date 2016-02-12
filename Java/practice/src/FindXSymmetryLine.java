import java.util.*;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
/*
improvement: partition by median. pick element from left part to find element in right part.
but this will take more space.
Another improvement: Use long to store two integer, and put the new long value into a hashset,
then just use contains to check if it has a corresponding point.
assume all points and median is int here. otherwise should use double to make it more precisely
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

    static int findLine(LinkedList<Point> points){
        int n = points.size();
        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.x - p2.x;
            }
        });

        int median = (n & 1) == 1 ? points.get(n / 2).x : (points.get(n / 2 - 1).x + points.get(n / 2).x) / 2;

        for(Point point: points){
            // traverse all the point to make sure all the node in the list has a accordingly node
            //other wise return -1;
            if(point.x != median){
                Point temp = new Point(2 * median - point.x, point.y);
                if(!findPoint(points, temp)) return -1;
            }
        }
        return median;
    }

    private static boolean findPoint(LinkedList<Point> points, Point newPoint){
        for(Point point: points){
            if(newPoint.x == point.x && newPoint.y == point.y) return true;
        }
        return false;
    }

    public static void main(String[] args){
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(1,2));
        points.add(new Point(5,2));
        points.add(new Point(4,3));
        System.out.println(findLine(points));
    }
}
